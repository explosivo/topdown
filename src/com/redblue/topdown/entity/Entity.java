package com.redblue.topdown.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.redblue.topdown.screen.Screen;

public class Entity {
	
	protected BufferedImage sprite;
	public int x, y;
	public int xx, yy;
	public int damage;
	public String name;
	boolean isSolid;
	boolean isAlive;
	boolean hurts;
	boolean isOnScreen = false;
	int speed;  
	
	public Image getSprite() {
		return sprite;
	}
	
	public boolean isOnScreen(){
		return isOnScreen;
	}
	
	public void render(Graphics g){
		g.drawImage(sprite, x, y, null);
	}

	public void render2(Screen screen, Graphics g){
		screen.render(g);
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	public void tick(){
	}
	
}
