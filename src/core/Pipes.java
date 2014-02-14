package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pipes {
	
	private int height = (int) (900*0.75);
	private int width = 90;
	private int spaceApart = 125;
	
	private int randomSpread = 300;
	
	private int y = 200;
	
	private int upY;
	private int downY;
	
	private String pipe_up_path = "res/pipe_up.png";
	private String pipe_down_path = "res/pipe_down.png";
	
	private Image pipe_up;
	private Image pipe_down;
	
	private Random randomizer = new Random();
	
	public Pipes() {
		try {
			
			pipe_up = ImageIO.read(new File(pipe_up_path));
			pipe_down = ImageIO.read(new File(pipe_down_path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void move() {
		
		if (y + randomSpread < height && y - randomSpread > 0) {
			y = randomizer.nextInt(((y + randomSpread) - (y - randomSpread)) + 1) + y - randomSpread;
		} 
		else if (y + randomSpread > height) {
			y = randomizer.nextInt(((y) - (y - randomSpread)) + 1) + y - randomSpread;
		}
		else {
			y = randomizer.nextInt(((y + randomSpread) - 20) + 1) + 20;
		}
		
	}
	
	
	public Image getPipeUp() {return pipe_up;}
	public Image getPipeDown() {return pipe_down;}
	
	public int getUpY() {return y + spaceApart;}
	public int getDownY() {return y;}
	public int getSpaceApart() {return spaceApart;}
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	
	
}
