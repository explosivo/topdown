package com.redblue.topdown;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{

	public boolean upPressed = false;
	public boolean downPressed = false;
	public boolean leftPressed = false;
	public boolean rightPressed = false;
	public boolean running = false;
	public boolean shotPressed = false;

	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) upPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_S) downPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_A) leftPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_D) rightPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_COMMA) shotPressed = true;
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) upPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_S) downPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_A) leftPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_D) rightPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_COMMA) shotPressed = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
