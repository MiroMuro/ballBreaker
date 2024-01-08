package brickBreakerGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final int screenHeight = (int)screenSize.getHeight();
	final int screenWidth = (int)screenSize.getWidth();
	private int delay = 10;
	private Ball ball;
	private Timer timer;
	private Rectangle paddle;
	boolean play = false;
	
	public Game() {
		ball = new Ball(screenWidth/2, screenHeight/2, 20); //spawn coordinates for the ball;
		paddle = new Rectangle(screenWidth/2-50,screenHeight/2+290, 100, 10);
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

		//Drawing the ball
		ball.draw(g);
		g.setColor(Color.blue);
		g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.Move();
		repaint();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
