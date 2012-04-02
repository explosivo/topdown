package com.redblue.topdown.screen;

import java.awt.Color;
import java.awt.Graphics;

import com.redblue.topdown.Topdown;

public class GameOverScreen extends Screen{
	int y = 640/Topdown.SCALE;
	String msg = "GameOver";
	
	public void render(Graphics g){
		if (y > (480/Topdown.SCALE)/2)
			y--;
		g.setColor(Color.WHITE);
		g.drawString(msg, (640/Topdown.SCALE)/2-25, y);
	}
	
}
