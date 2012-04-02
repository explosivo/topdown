package com.redblue.topdown.entity;
import java.awt.Graphics;

import com.redblue.topdown.Input;
import com.redblue.topdown.Topdown;
import com.redblue.topdown.sprites.Sprites;

public class Josh extends Creature{
	int time;
	Sprites sprites;
	Input input;
	int xp;
	int level;
	boolean hurt;
	boolean alive = true;
	boolean visible = true;
	int hurtTime;
	long counter1;
	long counter2;
	public Josh(Sprites sprites, Input input){
		level++;
		this.sprites = sprites;
		this.input = input;
		
		speed = 0;
		maxHealth = 10;
		health = maxHealth;
		sprite = sprites.getSprite(sprites.JOSHD1);
	}
	
	public void loseHealth(int damageAmmount){
		if (!hurt){
			hurt = true;						//make more better.
			health -= damageAmmount;
		}
	}
	
	public void render(Graphics g){
		if (visible)
			g.drawImage(sprite, x, y, null);
	}
	
	public void tick(){
		if (alive){
			if (health == 0)
				alive = false;
			if (hurt){
				hurtTime++;
				if (hurtTime > 0 && hurtTime < 50){
					visible = false;
				}
				if (hurtTime > 50 && hurtTime < 100){
					visible = true;
				}
				if (hurtTime > 150){
					hurtTime = 0;
					hurt = false;
					visible = true;
				}
			}
			if (input.downPressed){
				y++;
				time++;
				if(time < 50) {
					sprite = sprites.getSprite(3);
				}
				if(time >50 && time < 100) {
					sprite = sprites.getSprite(4);
				}
				if(time > 100 && time < 150) {
					sprite = sprites.getSprite(3);
				}
				if(time > 150 && time < 200) {
					sprite = sprites.getSprite(5);
				}
				if(time > 200)
					time = 0;
			}
			if (input.leftPressed){
				x--;
				time++;
				if(time < 50) {
					sprite = sprites.getSprite(sprites.JOSHL1);
					}
					if(time >50 && time < 100) {
						sprite = sprites.getSprite(sprites.JOSHL2);
					}
					if(time > 100 && time < 150) {
						sprite = sprites.getSprite(sprites.JOSHL1);
					}
					if(time > 150 && time < 200) {
						sprite = sprites.getSprite(sprites.JOSHL3);
					}
					if(time > 200)
						time = 0;
			}
			if (input.rightPressed){
				x++;
				time++;
				if(time < 50) {
					sprite = sprites.getSprite(sprites.JOSHR1);
					}
				if(time >50 && time < 100) {
					sprite = sprites.getSprite(sprites.JOSHR2);
				}
				if(time > 100 && time < 150) {
					sprite = sprites.getSprite(sprites.JOSHR1);
				}
				if(time > 150 && time < 200) {
					sprite = sprites.getSprite(sprites.JOSHR3);
				}
				if(time > 200)
					time = 0;
			}
			if (input.upPressed){
				y--;
				time++;
				if(time < 50) {
					sprite = sprites.getSprite(sprites.JOSHU1);
					}
					if(time >50 && time < 100) {
						sprite = sprites.getSprite(sprites.JOSHU2);
					}
					if(time > 100 && time < 150) {
						sprite = sprites.getSprite(sprites.JOSHU1);
					}
					if(time > 150 && time < 200) {
						sprite = sprites.getSprite(sprites.JOSHU3);
					}
					if(time > 200)
						time = 0;
			}
			if (input.running){
				speed*=2;
			}
			if (!input.running)
				speed = 5;
		}
		if(!alive){
			Topdown.triggerGameOver();
			if (y < 320)
				y ++;
			visible = true;
		}
	}
}
