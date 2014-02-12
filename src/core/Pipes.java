package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pipes {
	
	private int height = (int) (900*0.75);
	private int width = 90;
	private int spaceApart = 125;
	
	private int y = 400;
	
	private int upY;
	private int downY;
	
	private String pipe_up_path = "res/pipe_up.png";
	private String pipe_down_path = "res/pipe_down.png";
	
	private Image pipe_up;
	private Image pipe_down;
	
	public Pipes() {
		try {
			
			pipe_up = ImageIO.read(new File(pipe_up_path));
			pipe_down = ImageIO.read(new File(pipe_down_path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Image getPipeUp() {return pipe_up;}
	public Image getPipeDown() {return pipe_down;}
	
	public int getUpY() {return y + spaceApart;}
	public int getDownY() {return y;}
	public int getSpaceApart() {return spaceApart;}
	
	
	public void move() {
		
		
	}
	
}
