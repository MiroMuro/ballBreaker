package brickBreakerGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	private int x, y; //position of the ball
	private int diameter; //Diameter of the ball
	private int xSpeed, ySpeed; //X and Y velocity of the ball
	
	public Ball(int x, int y, int diameter) {
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.xSpeed = -3;
		this.ySpeed = -3;
	}
	
	public void Move() {
		x += xSpeed;
		y += ySpeed;
	}
	
	public void checkCollisionWithWalls(int screenWidth, int screenHeight) {
		//reverse direction on wall collision
		if(x <= screenWidth-300 || x >= screenWidth+300-diameter) {
			 xSpeed = -xSpeed;
		}
		//reverse direction on ceiling collision
		if(y == screenHeight) {
			ySpeed = -ySpeed;
		}
		
	}
	
	public void checkCollisionWithPaddle(Rectangle paddle) {
		if(getBounds().intersects(paddle)) {
			
		}
	}
	public Rectangle getBounds() {
		return  new Rectangle(x,y,diameter, diameter);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, diameter, diameter);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDiameter() {
		return diameter;
	}
}
