package com.redblue.topdown.entity;

import java.awt.Color;
import java.awt.Graphics;

public class Gun extends Weapon{
	
	static int number = 0;
	
	public Gun(int n){
		number = n;
		damage = 1;
		speed = 2;
	}
	
	public void tick(){
		
		if(x >= 0 && x <= 640/3 && y >= 0 && y <= 480/3){
			isOnScreen = true;
		}
		x = 10;
		y = 80;
	}
	public void render(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 3, 1);
	}
	public boolean isOnScreen() {
		return isOnScreen;
	}
}
