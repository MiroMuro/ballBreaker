package brickBreakerGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final int screenHeight = (int)screenSize.getHeight();
	final int screenWidth = (int)screenSize.getWidth();
	private int delay = 10;
	int score = 0;
	private Ball ball;
	private Paddle paddle;
	private BrickList blist = new BrickList(3,9);
	int numberOfBricks = 15;
	private Timer timer;
	boolean play = false;
	
	public Game() {
		addKeyListener(this);
		setFocusable(true);
		ball = new Ball(1100,620, 20); //spawn coordinates for the ball;
		paddle = new Paddle(screenWidth/2-50,screenHeight/2+290, 100, 10,20);
		timer = new Timer(delay,this);
		timer.start();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		
		g.fillRect(screenWidth-(screenWidth/2+300), screenHeight-(screenHeight/2+300),600,600);
		
		//Vasen laita
		g.setColor(Color.yellow);
		g.fillRect((screenWidth-(screenWidth/2+300)),(screenHeight-(screenHeight/2+300)),3,600);
		
		//Ylälaita
		g.setColor(Color.yellow);
		g.fillRect(screenWidth -(screenWidth/2+300),(screenHeight-(screenHeight/2+300)),600,3);
		
		//Oikea laita
		g.setColor(Color.yellow);
		g.fillRect((screenWidth-(screenWidth/2-300)),(screenHeight-(screenHeight/2+300)),3,600);
		
		g.setColor(Color.red);
		g.setFont(new Font("serif",Font.BOLD,30));
		g.drawString("Score: "+score, 910, 300);
		//Drawing the ball
		
		
		blist.draw((Graphics2D) g);
		ball.draw(g);
		paddle.draw(g);
		for(int i = 0; i < blist.list.length; i++) {
			for(int j = 0; j< blist.list[i].length; j++) {
				if(blist.list[i][j].destroyed == false) {
					blist.list[i][j].paint((Graphics2D) g);
				} else {
					blist.remove(i,j);
					score += 5;
				}
			}
			
		}
		if(ball.checkOutOfBounds(screenHeight-240) == false) {
			play = false;
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("You lost!",910,540);
		};
		
		
		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(play) {
			//Liikuta palloa.
			ball.Move();
			ball.checkCollisionWithWalls(screenWidth/2, screenHeight/2-300);
			ball.checkCollisionWithPaddle(paddle.getBounds());
			
			for(int i = 0; i < blist.list.length; i++) {
				for(int j = 0; j< blist.list[i].length; j++) {
					ball.checkCollisionWithBrick(blist.list[i][j]);
					repaint();
				}
				
			}
			
			repaint();
			// TODO Auto-generated method stub
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			if(paddle.getX() >=1210-paddle.getWidth()/2) {
				paddle.setX(1210 - paddle.getWidth()/2);
			}else {
				paddle.moveRight();
			}
			System.out.println("liikut oikealle");
		}
		repaint();
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(paddle.getX()<=613+paddle.getWidth()/2) {
				paddle.setX(613 + paddle.getWidth()/2);
			} else {
				paddle.moveLeft();
				System.out.println("liikut vasemmalle");
			}	
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			play = true;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
