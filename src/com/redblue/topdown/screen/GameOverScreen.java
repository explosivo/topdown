package com.redblue.topdown.screen;

import java.awt.Color;
import java.awt.Graphics;

public class GameOverScreen extends Screen{
	int y = 160;
	String msg = "GameOver";
	
	public void render(Graphics g){
		if (y > 80)
			y--;
		g.setColor(Color.WHITE);
		g.drawString(msg, 107-25, y);
	}
	
}
