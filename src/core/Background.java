package core;

import java.awt.Color;

public class Background {

	private Color background_color;
	
	private int shift = 5;
	
	private int red;
	private int green;
	private int blue;
	
	
	public Background() {
		
		red = 0;
		green = 255;
		blue = 255;
		
		
		background_color = new Color(red,green,blue);
		
		
	}
	
	public void darken() {
		if (green > 0) {
			green -= shift;
		} 
		else {
			blue -= shift;
		}
		background_color = new Color(red,green,blue);
	}
	
	public void lighten() {
		if (blue < 255) {
			blue += shift;
		} 
		else {
			green += shift;
		}
		background_color = new Color(red,green,blue);
	}
	
	public Color getColor() {
		return background_color;
	}
	
	public void resetColor() {
		red = 0;
		green = 225;
		blue = 255;
		background_color = new Color(red,green,blue);
	}
	
}
