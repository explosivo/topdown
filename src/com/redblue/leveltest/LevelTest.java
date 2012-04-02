package com.redblue.leveltest;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class LevelTest extends Canvas{
	static BufferedImage img;
	static int xx, yy;
	static int [][] pixels;
	static BufferedImage newImg;
	static Color t = new Color(0,0,0);
	
	public void paint(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(0, 0, 640, 480);
		g.drawImage(newImg, 0, 0, 100, 100, null);
	}
	
	public static void main(String[] args) {
		try {
			img = ImageIO.read(LevelTest.class.getResource("/com/redblue/topdown/sprites/level.png"));
			xx = img.getWidth();
			yy = img.getHeight();
			pixels = new int [xx][yy];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int n = 0;
		for(int x = 0; x < img.getWidth(); x ++){
			for(int y = 0; y < img.getHeight(); y++){
				if (img.getRGB(x, y) == -16713642)
					pixels[x][y] = img.getRGB(x, y);
			}
		}
		newImg = new BufferedImage(xx, yy, BufferedImage.TRANSLUCENT);
		for(int x = 0; x < img.getWidth(); x ++){
			for(int y = 0; y < img.getHeight(); y++){
					newImg.setRGB(x, y, pixels[x][y]);
			}
		}
		System.out.println(pixels[0][0]);
		LevelTest lt = new LevelTest();
		JFrame win = new JFrame();
		win.add(lt);
		win.setSize(200, 200);
		win.setLocationRelativeTo(null);
		win.setVisible(true);
	}
}
