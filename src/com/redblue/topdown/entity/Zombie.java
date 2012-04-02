package com.redblue.topdown.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.redblue.topdown.Input;
import com.redblue.topdown.Topdown;
import com.redblue.topdown.sprites.Sprites;

public class Zombie extends Creature{

	Random random = new Random();
	int time;
	Input input;
	int dir;
	int dirTime;
	public static int number = 0;
	int thisNumber;
	boolean alive = true;
	Josh josh;
	Sprites sprites = new Sprites();
	BufferedImage zombied1 = sprites.getSprite(sprites.ZOMBIED1);
	BufferedImage zombied2 = sprites.getSprite(sprites.ZOMBIED2);
	BufferedImage zombied3 = sprites.getSprite(sprites.ZOMBIED3);
	BufferedImage zombieu1 = sprites.getSprite(sprites.ZOMBIEU1);
	BufferedImage zombieu2 = sprites.getSprite(sprites.ZOMBIEU2);
	BufferedImage zombieu3 = sprites.getSprite(sprites.ZOMBIEU3);
	BufferedImage zombiel1 = sprites.getSprite(sprites.ZOMBIEL1);
	BufferedImage zombiel2 = sprites.getSprite(sprites.ZOMBIEL2);
	BufferedImage zombiel3 = sprites.getSprite(sprites.ZOMBIEL3);
	BufferedImage zombier1 = sprites.getSprite(sprites.ZOMBIER1);
	BufferedImage zombier2 = sprites.getSprite(sprites.ZOMBIER2);
	BufferedImage zombier3 = sprites.getSprite(sprites.ZOMBIER3);
	
	public Zombie(Input input, int xx, int yy, Josh josh){
		this.input = input;
		this.josh = josh;
		number ++;
		thisNumber = number;
		damage = 1;
		maxHealth = 1;
		sprite = null;
		isNPC = true;
		speed = 1;
		hurts = true;
		isSolid = true;
		x = random.nextInt((xx) +1);
		y = random.nextInt((yy) +1);
		sprite = zombied1;
	}
	
	public boolean isAlive(){
		return alive;
	}

	public void remove(){
		if (alive){
			number--;
			alive = false;
		}
	}
	
	public void render(Graphics g){
		if (alive){
			g.drawImage(sprite, x, y, null);
			g.setColor(Color.white);
		}
		//g.setFont(new Font("Aerial", 10, 10));
		//g.drawString(String.valueOf(thisNumber), x - 5, y + 20);
	}
	
	public void tick(){
		if (alive){
			time++;
		
		if (dirTime == 0){
			dirTime = random.nextInt((100) +1);
			dir = random.nextInt((3)+1);
		}
		/*if (((x >= josh.x) && (x <= josh.x+16)) && ((y >= josh.y) && (y <= josh.y + 32)) || 
			((x+16 >= josh.x) && (x+16 <= josh.x)) && ((y+32 >= josh.y) && (y+32 <= josh.y + 32))){*/
		if ( ((x <= josh.x) && (x + 16 >= josh.x)) && ((y <= josh.y) && (y + 32 >= josh.y)) ||
				((x <= josh.x + 16) && (x + 16 >= josh.x + 16)) && ((y <= josh.y + 32) && (y + 32 >= josh.y + 32))){
				josh.loseHealth(damage);
		}
		
		
		
		if (time > 4 && time < 7){
			if (dir == 0){
				if(dirTime < 25) {
					sprite = zombieu1;
				}
				if(dirTime >25 && dirTime < 50) {
					sprite = zombieu2;
				}
				if(dirTime > 50 && dirTime < 75) {
					sprite = zombieu1;
				}
				if(dirTime > 75 && dirTime < 100) {
					sprite = zombieu3;
				}
				y-=speed;
			}
			if (dir == 1){
				if(dirTime < 25) {
					sprite = zombied1;
				}
				if(dirTime >25 && dirTime < 50) {
					sprite = zombied2;
				}
				if(dirTime > 50 && dirTime < 75) {
					sprite = zombied1;
				}
				if(dirTime > 75 && dirTime < 100) {
					sprite = zombied3;
				}
				y+=speed;
			}
			if (dir == 2){
				if(dirTime < 25) {
					sprite = zombier1;
				}
				if(dirTime >25 && dirTime < 50) {
					sprite = zombier2;
				}
				if(dirTime > 50 && dirTime < 75) {
					sprite = zombier1;
				}
				if(dirTime > 75 && dirTime < 100) {
					sprite = zombier3;
				}
				x+=speed;
			}
			if (dir == 3){
				if(dirTime < 25) {
					sprite = zombiel1;
				}
				if(dirTime >25 && dirTime < 50) {
					sprite = zombiel2;
				}
				if(dirTime > 50 && dirTime < 75) {
					sprite = zombiel1;
				}
				if(dirTime > 75 && dirTime < 100) {
					sprite = zombiel3;
				}
				x-=speed;
			}
			dirTime--;
		}
		if (time > 9){
			time = 0;
		}
		}
	}
	
}
