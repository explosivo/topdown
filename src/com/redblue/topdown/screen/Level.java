package com.redblue.topdown.screen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.redblue.topdown.Input;
import com.redblue.topdown.entity.Josh;
import com.redblue.topdown.entity.Zombie;
import com.redblue.topdown.sprites.Sprites;

public class Level extends Screen{
	int[] enemies = new int [1];
	int[] size = new int[2];
	//int [] tiles;
	static int number;
	int x,y;
	BufferedImage floor;
	Sprites sprites;
	Input input;
	int time;
	int speed=1;
	int zombies = 100;
	Zombie[] zombie = new Zombie[zombies];
	Josh josh;
	BufferedImage levelimg = new BufferedImage(320,240,BufferedImage.TYPE_INT_RGB);
	
	public Level(Sprites sprites, Input input, Josh josh){
		this.sprites = sprites;
		this.input = input;
		this.josh = josh;
	}
	
	public void drawFloor(){
		//later try BufferedImage[] floor. (for setting specific tiles)
		int n = 0;
		floor = new BufferedImage(size[0] * 16, size[1] * 16, BufferedImage.TYPE_INT_RGB);
		Graphics g = floor.getGraphics();
		for(int xx = 0; xx < size[0]; xx++){
			for (int yy = 0; yy < size[1]; yy ++){
				//g.setColor(Color.red);
				//g.fillRect(xx*16, yy*16, 16, 16);
				g.drawImage(sprites.getSprite(sprites.WHITE), xx * 16*2, yy * 16 * 2, null);
				g.drawImage(sprites.getSprite(sprites.BLACK), xx * 16 * 2 - 16, yy * 16 * 2 - 16, null);
			}
		}
		g.dispose();
	}

	public void initLevel(int width, int height){
		number ++;
		this.size[0] = width;
		this.size[1] = height;
		drawFloor();
		makeZombies(zombies);
	}
	
	public void makeZombies(int zombies){
		for (int i = 0; i < zombies; i ++){
			zombie[i] = new Zombie(input, size[0] * 16, size[1] * 16, josh);
		}
	}
	
	public void render(Graphics gg){
		//Graphics gg = levelimg.getGraphics();
		gg.translate(640/4-josh.x,480/4-josh.y);
		gg.setColor(Color.BLUE);
		gg.fillRect(-10, 0, 640, 480);
		gg.drawImage(floor, 0, 0, null);
		josh.render(gg);
		for (int i = 0; i < zombies; i ++){
				zombie[i].render(gg);
		}
		if(input.shotPressed){
			gg.setColor(Color.white);
			gg.fillRect(320-josh.x+8, 240-josh.y-16, 640, 480);
			gg.dispose();
		}
		//g.drawImage(levelimg, 0, 0, 640, 480, null);
	}
	public void tick(){
		//System.out.println(Zombie.number);
		time++;
		if (time > 5 && time < 9){
			if(input.shotPressed){
				for(int i = 0; i < zombies; i++){
					if(zombie[i].isAlive());
					if (zombie[i].isOnScreen())
						zombie[i].remove();
				}
			}
		}
		if (time > 9){
			time = 0;
		}
		for (int i = 0; i < zombies; i ++){
			zombie[i].tick();
		}
	}
	
}
