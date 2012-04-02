package com.redblue.topdown.screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.redblue.topdown.Input;
import com.redblue.topdown.Topdown;
import com.redblue.topdown.entity.Josh;

public class GuiOverlay {
	
	int ups;
	int fps;
	Josh josh;
	Input input;
	
	public GuiOverlay(Josh josh, Input input){
		this.josh = josh;
		this.input = input;
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, 640, (480/8));
		if  (System.currentTimeMillis() - Topdown.counter > 1000){
			Topdown.counter += 1000;
			ups = Topdown.updates;
			fps = Topdown.frames;
			Topdown.frames = 0;
			Topdown.updates = 0;
		}
		g.setColor(Color.white);
		g.setFont(new Font("Aerial", 18, 18));
		g.drawString("UPS: " + ups, 10, 50);
		g.drawString("FPS: " + fps, 200, 50);
		g.drawString("Health: " + josh.health , 400, 50);
		g.drawString("x: " + josh.x , 325, 20);
		g.drawString("y: " + josh.y , 400, 20);
		g.drawString(Topdown.name + " " + Topdown.version, 640 - (640), 480 - 460);
		
	}

}