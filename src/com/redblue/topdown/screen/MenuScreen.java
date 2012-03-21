package com.redblue.topdown.screen;

import java.awt.Color;
import java.awt.Graphics;

public class MenuScreen extends Screen{
	
	public void render(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 640, 480);
	}

}
