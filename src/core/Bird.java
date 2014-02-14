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
	
	private int width = 43;
	private int height = 31                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ;
	
	private int x = 120;
	private float y = 200;
	
	private float fallingSpeed = 0f;
	private float jumpingSpeed = 4f;
	
	private float dy = 0f;
	
	private float gravity = 0.03f;
	//private float gravity = 0.025f;

	private float antiGravity = -0.15f;
	//private float antiGravity = -0.1f;
	
	private boolean isFalling;
	
	
	private String bird_path = "res/derpybird_small.png";
	
	private Image bird_img;
	
	
	public Bird() {
		
		isFalling = true;
		
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
	
		
		if (isFalling) {
			dy = dy+gravity;
			y += dy;
		}
		else {
			y -= dy;
			dy = dy+antiGravity;
		}
		if (dy < 0.01f) {
			isFalling = true;
			dy = 0.02f;
		}
		if (y < 0) {
			isFalling = true;
			dy = 0.02f;
			move();
		}
	}
	
	public void jump() {
		isFalling = false;
		dy = jumpingSpeed;
		move();
	}

	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public int getX() {return x;}
	public float getY() {return y;}

	
	
}


