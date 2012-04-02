package com.redblue.topdown.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprites {
	BufferedImage spriteSheet;
	BufferedImage[] sprites = new BufferedImage[256];
	int WIDTH, HEIGHT;
	//int[][] pixels; //-- later
	//PixelGrabber px;
	
	
/*	public static final String[] spriteNames = {
								  "JOSHR1", //0
								  "JOSHR2", //1
								  "JOSHR3", //2
								  "JOSHD1", //3
								  "JOSHD2", //4
								  "JOSHD3", //5
								  "JOSHL1", //6
								  "JOSHL2", //7
								  "JOSHL3", //8
								  "JOSHU1", //9
								  "JOSHU2", //10
								  "JOSHU3"  //11
	};*/
	//josh
	public final int JOSHR1 = 0;
	public final int JOSHR2 = 1;
	public final int JOSHR3 = 2;
	public final int JOSHD1 = 3;
	public final int JOSHD2 = 4;
	public final int JOSHD3 = 5;
	public final int JOSHL1 = 6;
	public final int JOSHL2 = 7;
	public final int JOSHL3 = 8;
	public final int JOSHU1 = 9;
	public final int JOSHU2 = 10;
	public final int JOSHU3 = 11;
	
	public final int ZOMBIER1 = 13;
	public final int ZOMBIER2 = 14;
	public final int ZOMBIER3 = 15;
	public final int ZOMBIED1 = 16;
	public final int ZOMBIED2 = 17;
	public final int ZOMBIED3 = 18;
	public final int ZOMBIEL1 = 19;
	public final int ZOMBIEL2 = 20;
	public final int ZOMBIEL3 = 21;
	public final int ZOMBIEU1 = 22;
	public final int ZOMBIEU2 = 24;
	public final int ZOMBIEU3 = 25;

	//16x32
	 
	public final int GRASS1 = 12;
	public final int BLACK = 26;
	public final int WHITE  = 27;

	//16x16
	
	public Sprites(){
		try {
			spriteSheet = ImageIO.read(Sprites.class.getResource("/com/redblue/topdown/sprites/sprites.png"));
			
			WIDTH = spriteSheet.getWidth(null);
			HEIGHT = spriteSheet.getHeight(null);
			
			getJosh();
			getZombie();
			
			getGrass();
			
			getBlackandWhite();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error - Sprites context: " + e);
		}
	}
	
	void getBlackandWhite(){
		sprites[26] = spriteSheet.getSubimage(112, 1, 16, 16);
		sprites[27] = spriteSheet.getSubimage(128, 1, 16, 16);
	}
	
	void getGrass(){
		sprites[12] = spriteSheet.getSubimage(96, 1, 16, 16);
	}
	
	void getJosh(){
		for(int i = 0; i < 6; i++){
			sprites[i] = spriteSheet.getSubimage((i * 16) + 1, 1, 15, 31);
		}
		for(int i = 6; i < 12; i++){
			sprites[i] = spriteSheet.getSubimage(((i - 6)* 16) + 1, 33, 15, 31);
		}
	}
	
	public BufferedImage getSprite(int i){
		return sprites[i];
	}
	void getZombie(){
		for(int i = 13; i < 19; i++){
			sprites[i] = spriteSheet.getSubimage(((i - 13) * 16) + 1, 65, 15, 31);
		}
		for(int i = 19; i < 25; i++){
			sprites[i] = spriteSheet.getSubimage(((i - 19)* 16) + 1, 97, 15, 31);
		}
	}
	
}
