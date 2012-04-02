package com.redblue.topdown.entity;

import java.awt.Color;
import java.awt.Graphics;

public class Gun extends Weapon{
	
	static int number = 0;
	public boolean alive = true;
	
	int time = 0;
	
	public Gun(int n){
		number = n;
		damage = 1;
		speed = 2;
	}
	
	public boolean isOnScreen() {
		return isOnScreen;
	}
	public void render(Graphics g){
		if (alive){
			g.setColor(Color.white);
			g.fillRect(0, 0, 640, 480);
		}
	}
	public void tick(){
		time++;
		if (alive){
			if(x >= 0 && x <= 640/3 && y >= 0 && y <= 480/3){
				isOnScreen = true;
			}
			alive = false;
		}
	}
}