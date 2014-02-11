package core;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private int width = (int)(600*0.75);
	private int height = (int)(900*0.75);

	public Window() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(width, height));
		this.setVisible(true);
		
		
	}
}
