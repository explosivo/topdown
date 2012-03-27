package com.redblue.topdown;

import com.redblue.topdown.entity.Josh;
import com.redblue.topdown.screen.Level;

public class Tick extends Thread{

	Josh josh;
	Level level;
	long lastUpdate = 0;
	
	Tick(Josh josh, Level level){
		this.josh = josh;
		this.level = level;
	}
	@Override
	public void run() {
			while(Topdown.running && !Topdown.paused){
				try {
					Topdown.updates ++;
					josh.tick();
					level.tick();
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}

}
