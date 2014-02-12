package core;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pipes extends JPanel{
	
	private int height = (int) (900*0.75);
	private int width = 90;
	private int spaceApart = 65;
	
	
	public Pipes() {
		
		this.setPreferredSize(new Dimension(width, height));
		this.setVisible(true);
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawRect(200, 0, width, height);
		repaint();
	}
		
	
}
