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

public class Bird extends JLabel{
	
	private int width = 45;
	private int height = 31;
	
	String bird_path = "res/derpybird_small.png";
	
	private BufferedImage bird_img;
	
	public Bird() {
		
		this.setVisible(true);
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLUE);
		
		try {
			bird_img = new BufferedImage(45,45,BufferedImage.TYPE_INT_ARGB);
			bird_img = ImageIO.read(new File(bird_path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImageIcon bird_icon = new ImageIcon(bird_img);
		this.setIcon(bird_icon);
		
		
	}

	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	
	
}


