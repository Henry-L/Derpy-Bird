package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class World extends JPanel implements ActionListener{
	
	private Timer timer;
	private Bird bird;
	private Pipes pipes;
	
	private int pipeDownLen;
	private int pipeUpLen;
	
	public World() {
		
		this.setFocusable(true);
		this.setBackground(Color.BLUE);
		this.setDoubleBuffered(true);
	
		
		bird = new Bird();
		pipes = new Pipes();
		
		pipeDownLen = pipes.getPipeDown().getHeight(this);
		pipeUpLen = pipes.getPipeUp().getHeight(this);
		
		
		int len = pipes.getPipeDown().getHeight(this);
		System.out.println(pipes.getDownY() - pipeDownLen);
		
		addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
	        	if (e.getKeyChar() == ' ') {
					bird.jump();
				}
	        }
		});
		
		timer = new Timer(5, this);
		timer.start();
		
	}
	
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        //g2d.rotate(Math.toRadians(10), (int)(bird.getX()), (int)(bird.getY()));
        g2d.drawImage(bird.getBird(), (int)(bird.getX()), (int)(bird.getY()), this);
        g2d.drawImage(pipes.getPipeUp(), 300, pipes.getUpY(), this);
        g2d.drawImage(pipes.getPipeDown(), 300, pipes.getDownY() - pipeDownLen, this);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		bird.move();
		repaint();
		
	}
}
