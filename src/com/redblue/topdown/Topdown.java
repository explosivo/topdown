package com.redblue.topdown;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

import com.redblue.topdown.screen.*;


public class Topdown extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	static final int WIDTH = 320;
	static final int HEIGHT = 240;
	private boolean running = false;
	private Graphics dbg;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	Screen screen;
	MenuScreen menu;
	static long frames = 0;
	
	public void start(){
		if (!running){
			 screen = new Screen();
			new Thread(this).start();
		}
	}
	
	public void run(){
		long counter = System.currentTimeMillis();
		running = true;
		while(running){
			gameUpdate();
			gameRender();
			paintScreen();
	
			
			if (System.currentTimeMillis() - counter > 1000){
				counter += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			try{
				Thread.sleep(2);
			}catch(InterruptedException e){
				e.printStackTrace();
				System.out.println("Error: " + e);
			}
		}
	}
	
	public void gameUpdate(){
		if(running){
			
		}
	}
	public void paintScreen(){
		frames ++;
		Graphics g = getGraphics();
		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
	}
	public void gameRender(){
		dbg = image.createGraphics();
		screen.render(dbg);
	}
	
	
	public static void main(String[] args) {
		Topdown topdown = new Topdown();
		JFrame win = new JFrame("Topdown");
		win.setLayout(new BorderLayout());
		win.add(topdown, BorderLayout.CENTER);
		win.setSize(WIDTH, HEIGHT);
		win.setResizable(false);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		
		topdown.start();
	}

}