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
		g.fillRect(0, 0, 640/3, (480/8)/3);
		if  (System.currentTimeMillis() - Topdown.counter > 1000){
			Topdown.counter += 1000;
			ups = Topdown.updates;
			fps = Topdown.frames;
			Topdown.frames = 0;
			Topdown.updates = 0;
		}
		g.setColor(Color.white);
		g.drawString("UPS: " + ups, 10/3, 50/3);
		g.drawString("FPS: " + fps, 200/3, 50/3);
		g.drawString("Health: " + josh.health , 400/3, 50/3);
		//g.setFont(new Font("Aerial", 8, 8));
		//g.drawString(Topdown.name + " " + Topdown.version, 640/3 - 200, 480/3 - 20);
		
	}

}
