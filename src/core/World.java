package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

public class World extends JPanel implements ActionListener{
	
	private int width, height;
	
	private int numGameOvers = 0;
	
	private Timer timer;
	
	private Timer colorTimer;
	
	private int score;
	
	private Bird bird;
	private Pipes pipes;
	private Pipes pipes2;
	
	private int pipeDownLen;
	private int pipeUpLen;
	
	private int dx = 1;
	
	private int pipeStart;
	
	private int px1;
	private int px2;
	
	private boolean gameStarted;
	private boolean gameOver;
	
	private BufferedReader hsReader;
	private BufferedWriter hsWriter;
	private String highScore_path = "res/high_score.txt";
	private String highScore;
	
	private Background background;
	
	private boolean darkening;
	
	public World(int width, int height) {
		
		background = new Background();
		
		this.setFocusable(true);
		this.setBackground(background.getColor());
		this.setDoubleBuffered(true);
		
		this.width = width;
		this.height = height;
		
		pipeStart = 600;
	
		score = 0;
		
		bird = new Bird();
		pipes = new Pipes();
		pipes.move();
		pipes2 = new Pipes();
		pipes2.move();
		
		darkening = true;
		
		System.out.println("Pipes width = " + pipes.getWidth());
		
		px1  = pipeStart;
		
		px2 = (int) (pipeStart + pipeStart - bird.getX()*2);
				
		pipeDownLen = pipes.getPipeDown().getHeight(this);
		pipeUpLen = pipes.getPipeUp().getHeight(this);

		try {
			if (new File(highScore_path) != null) {
				hsReader = new BufferedReader(new FileReader(highScore_path));
				highScore = hsReader.readLine();
				hsReader.close();
			} 
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
	        	if (e.getKeyChar() == ' ') {
	        		
	        		if (!gameStarted) {
	        			gameStarted = true;
	        			timer.start();
	        			colorTimer.start();
        			}
	        	
				}
	        	
	        	if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	        		if (gameOver) {
	        			gameStarted = false;
	        			gameOver = false;
	        			restart();
	        			repaint();
	        		}
	        		
	        	}
	        	
	        	bird.jump();
	        }
		});
		
		timer = new Timer(5, this);
		
		colorTimer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (background.getColor().getBlue() == 0) {
					darkening = false;
				}
				else if(background.getColor().getGreen() == 255) {
					darkening = true;
				}
				if (darkening) {
					background.darken();
				} else {
					background.lighten();
				}
			}
			
		});
	}
	
    public void paint(Graphics g) {
        super.paint(g);

      
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.white);
    	g2d.setFont(new Font("Ariel", Font.PLAIN, 20));
    	
        if (!gameStarted){
        	g2d.drawString("Press Space to Jump", 100, 100);
        }
        //g2d.rotate(Math.toRadians(10), (int)(bird.getX()), (int)(bird.getY()));
        g2d.drawImage(bird.getBird(), (int)(bird.getX()), (int)(bird.getY()), this);
        g2d.drawImage(pipes.getPipeUp(), px1, pipes.getUpY(), this);
        g2d.drawImage(pipes.getPipeDown(), px1, pipes.getDownY() - pipeDownLen, this);
     
        g2d.drawImage(pipes2.getPipeUp(), px2, pipes2.getUpY(), this);
        g2d.drawImage(pipes2.getPipeDown(), px2, pipes2.getDownY() - pipeDownLen, this);
        
        g2d.drawString("Score: " + score, width - 100, 20);
        
        Toolkit.getDefaultToolkit().sync();
        
        if (gameOver) {
        	g2d.drawString("Game Over!", 100, 100);
        	g2d.drawString("High Score:  " + highScore, 100, 120);
        	g2d.drawString("Press Enter to Retry.", 100, 250);
        	
        	switch (numGameOvers) {
        	
        	case 10: 
        		g2d.drawString("You still want to play??", 100, 200);
        	}
        }
        
        g2d.dispose();
    }

    public boolean checkCollision() {
    	
    	int x =  bird.getX();
    	int x2 = bird.getX() + bird.getWidth();
    	
    	int y = (int) bird.getY();
    	int y2 = (int) bird.getY() + bird.getHeight();
    	
    	
    	if (y2 >= height) {
    		return true;
    	}
    	
    	
    	if ((x > px1 && x < px1+pipes.getWidth() - 20) || (x2 > px1 && x2 < px1+pipes.getWidth() - 20)) {
    		if ((y < pipes.getDownY() || y > pipes.getUpY()) || (y2 < pipes.getDownY() || y2 > pipes.getUpY())) {
    			System.out.println("Bird x = " + x);
    			System.out.println("Pipe x + width = " + (px1+pipes.getWidth()));
    			return true;
    		}
    	}
    	
    	if ((x > px2 && x < px2+pipes2.getWidth() - 20) || (x2 > px2 && x2 < px2+pipes2.getWidth() - 20)) {
    		if ((y < pipes2.getDownY() || y > pipes2.getUpY()) || (y2 < pipes2.getDownY() || y2 > pipes2.getUpY())) {
    			System.out.println("Bird x = " + x);
    			System.out.println("Pipe2 x + width = " + (px2+pipes.getWidth()));
    			return true;
    		}
    	}
    	
    	return false;
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.setBackground(background.getColor());
		
		
		
		if (bird.getX() == (px1+pipes.getWidth()+dx) || bird.getX() == (px2+pipes.getWidth()+dx)) {
			/*if (background.getColor().getBlue() > 0) {
				background.darken();
				this.setBackground(background.getColor());
			}*/
			score++;
		}
		
		if (checkCollision()) {
			timer.stop();
			colorTimer.stop();
			gameOver = true;
			numGameOvers++;
			
			if (score > Integer.parseInt(highScore)) {
				highScore = ""+score;
				try {
					hsWriter = new BufferedWriter(new FileWriter(highScore_path));
					hsWriter.write(highScore);
					hsWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	
		if (px1 + pipes.getWidth() < 0) {
			px1 = pipeStart;
			pipes.move();
		}
		if (px2 + pipes.getWidth() < 0) {
			px2 = pipeStart;
			pipes2.move();
		}
		
		px1 -= dx;
		px2 -= dx;
	
		bird.move();
		repaint();
		
	}
	

	
	public void restart() {
		bird = new Bird();
		pipes = new Pipes();
		pipes2 = new Pipes();
		
		px1  = pipeStart;
		px2 = (int) (pipeStart + pipeStart - bird.getX()*2);
		
		background.resetColor();
		this.setBackground(background.getColor());
		score = 0;
	}
}
