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
		if (getBounds().intersects(paddle)) {
	        // Calculate ball's center
	        int ballCenterX = x + diameter / 2;

	        // Calculate where the ball hit on the paddle
	        int paddleCenterX = paddle.x + paddle.width / 2;
	        int deltaX = ballCenterX - paddleCenterX;

	        // Adjust ball's speed based on collision point on the paddle
	        double collisionRatio = deltaX / (paddle.width / 2.0);
	        int maxBounceAngle = 120; // Max angle for ball's bounce from the paddle

	        // Calculate new xSpeed based on the collision point
	        double bounceAngle = collisionRatio * maxBounceAngle;
	        double radianAngle = Math.toRadians(bounceAngle);
	        xSpeed = (int) (Math.sin(radianAngle) * 5); // Adjust the 5 for paddle speed
	        ySpeed = -ySpeed; // Reverse direction on paddle collision
	    }
	}
	public void checkOutOfBounds(int screenBottomBorder) {
		if( y < screenBottomBorder) {
			
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
