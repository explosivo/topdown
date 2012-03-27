package com.redblue.topdown.screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.redblue.topdown.Input;
import com.redblue.topdown.entity.Gun;
import com.redblue.topdown.entity.Josh;
import com.redblue.topdown.entity.Zombie;
import com.redblue.topdown.sprites.*;

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
	Gun[] gun = new Gun[4];
	int shotCount = 0;
	int maxShots = 3;
	Zombie[] zombie = new Zombie[2056];
	int zombies = 200;
	Josh josh;
	
	public Level(Sprites sprites, Input input, Josh josh){
		this.sprites = sprites;
		this.input = input;
		this.josh = josh;
	}
	
	public void initLevel(int width, int height){
		number ++;
		this.size[0] = width;
		this.size[1] = height;
		drawFloor();
		makeZombies(zombies);
	}

	public void tick(){
		time++;
		if (time > 5 && time < 9){
			if(input.shotPressed && shotCount < maxShots){
				gun[shotCount] = new Gun(shotCount);
				shotCount++;
				if (shotCount > maxShots)
					shotCount = 0;
			}
		for(int i = 0; i < shotCount; i++){
			gun[i].tick();
		}
		if (input.downPressed){
			y-=speed;
		}
		if (input.upPressed){
			y+=speed;
		}
		if (input.rightPressed){
			x-=speed;
		}
		if(input.leftPressed){
			x+=speed;
		}
		}
		if (time > 9){
			time = 0;
		}
		for (int i = 0; i < zombies; i ++){
			zombie[i].tick();
		}
	}
	
	public void render(Graphics g){
		g.drawImage(floor, x, y, null);
		for(int i = 0; i < shotCount; i++){
			if (gun[i].isOnScreen())
				gun[i].render(g);
		}
		for (int i = 0; i < zombies; i ++){
			if (zombie[i].isOnScreen())
				zombie[i].render(g);
		}
	}
	
	public void drawFloor(){
		floor = new BufferedImage(size[0] * 16, size[1] * 16, BufferedImage.TYPE_INT_RGB);
		Graphics g = floor.getGraphics();
		for(int x = 0; x < size[0]; x++){
			for (int y = 0; y < size[1]; y ++){
				g.drawImage(sprites.getSprite(sprites.GRASS1), x * 16, y * 16, null);
			}
		}
		g.dispose();
	}
	public void makeZombies(int zombies){
		for (int i = 0; i < zombies; i ++){
			zombie[i] = new Zombie(input, size[0] * 16, size[1] * 16, josh);
		}
	}
	
}
