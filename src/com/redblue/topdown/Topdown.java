package com.redblue.topdown;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.redblue.topdown.entity.Josh;
import com.redblue.topdown.screen.Camera;
import com.redblue.topdown.screen.GameOverScreen;
import com.redblue.topdown.screen.GuiOverlay;
import com.redblue.topdown.screen.Level;
import com.redblue.topdown.screen.MenuScreen;
import com.redblue.topdown.screen.Screen;
import com.redblue.topdown.sprites.Sprites;


public class Topdown extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static final String name = "Topdown";
	public static final String version = "Pre-Alpha 0.1a";
	public static final int SCALE = 1;
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static boolean running = false;
	public static boolean paused = false;
	public static boolean gameOver = false;
	Thread tick;
	private Graphics dbg;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	GameOverScreen gameover = new GameOverScreen();
	Screen screen;
	Input input = new Input();
	MenuScreen menu;
	Josh josh;
	Level level;
	GuiOverlay guioverlay;
	static Sprites sprites = new Sprites();
	public static int frames = 0;
	public static int updates = 0;
	public static long counter;
	
	public static boolean triggerGameOver(){
		return gameOver = true;
	}
	
	public void start(){
		if (!running){
			requestFocus();
			addKeyListener(input);
			screen = new Screen();
			menu = new MenuScreen();
			josh = new Josh(sprites, input);
			level = new Level(sprites, input, josh);
			level.initLevel(100, 100);
			guioverlay = new GuiOverlay(josh, input);
			tick = new Thread(new Tick(josh, level));
			new Thread(this).start();
		}
	}
	
	public void run(){
		tick.start();
		counter = System.currentTimeMillis();
		running = true;
		while(running){
			//gameUpdate();
			gameRender();
			paintScreen();
			try{
				Thread.sleep(2);
			}catch(InterruptedException e){
				e.printStackTrace();
				System.out.println("Error: " + e);
			}
		}
	}
	
	public void gameRender(){
		dbg = image.createGraphics();
		menu.render(dbg);
		level.render(dbg);
		dbg = image.createGraphics();
		guioverlay.render(dbg);
		if (gameOver)
			gameover.render(dbg);
		dbg.dispose();
	}
	/*public void gameUpdate(){
		//updates ++;
		if (!isFocusOwner()){
			paused = true;
		}
		if (isFocusOwner()){
			paused = false;
		}
		if(running && !paused){
			josh.tick();
			level.tick();
		}
	}*/
	public void paintScreen(){
		frames ++;
		Graphics g = getGraphics();
		g.drawImage(image, 0, 0, 640,480, null);
		g.dispose();
	}
	
	
	public static void main(String[] args) {
		Topdown topdown = new Topdown();
		JFrame win = new JFrame(name + " " + version);
		win.setLayout(new BorderLayout());
		win.add(topdown, BorderLayout.CENTER);
		win.setSize(640, 480);
		win.setResizable(false);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		
		topdown.start();
	}
	

}