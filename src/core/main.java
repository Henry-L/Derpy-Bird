package core;

import java.awt.Point;

public class main {

	private static Point startingPoint = new Point(45, 200);
	
	public static void main(String[] args) {
		Window w = new Window();
		
		Bird bird = new Bird();
		bird.setSize(bird.getWidth(), bird.getHeight());
		bird.setLocation(startingPoint);
		
		w.add(bird);
		
		bird.repaint();

	}

}
