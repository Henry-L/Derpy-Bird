package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bird {
	
	private int width = 45;
	private int height = 31;
	
	private int x = 45;
	private int y = 200;
	
	private int dy = 3;
	
	private String bird_path = "res/derpybird_small.png";
	
	private Image bird_img;
	
	
	public Bird() {
		
		try {
			
			bird_img = ImageIO.read(new File(bird_path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Image getBird() {
		return bird_img;
	}
	
	public void move() {
		
		y += dy;
	}

	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public int getX() {return x;}
	public int getY() {return y;}

	
	
}


