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
		this.ySpeed = -6;
	}
	
	public void Move() {
		x += xSpeed;
		y += ySpeed;
	}
	
	public void checkCollisionWithWalls(int screenWidth, int screenHeight) {
		System.out.println(screenHeight);
		//reverse direction on wall collision
		if(x <= screenWidth-300 || x >= screenWidth+300-diameter) {
			 xSpeed = -xSpeed;
		}
		//reverse direction on ceiling collision
		if(y < screenHeight -4 ) {
			System.out.println("HWERE");
			ySpeed = -ySpeed;
		}
		
	}
	
	public void checkCollisionWithPaddle(Rectangle paddle) {
		System.out.println(ySpeed);
	    if (getBounds().intersects(paddle)) {
	        int paddleCenterX = paddle.x + paddle.width / 2;
	        int ballCenterX = x + diameter / 2;

	        double collisionPoint = ballCenterX - paddleCenterX;
	        double normalizedCollisionPoint = collisionPoint / (paddle.width / 2.0);

	        double bounceAngle = normalizedCollisionPoint * Math.PI / 3; // Adjust for desired bounce angle

	        xSpeed = (int) (5 * Math.sin(bounceAngle));
	        
	        // Ensure a minimum vertical speed to prevent vertical sliding
	        ySpeed = (int) Math.max(-12, -8 * Math.cos(bounceAngle)); // -5 to reverse direction, -4 is the minimum vertical speed

	        // Adjust the ball's position above the paddle to avoid sticking
	        y = paddle.y - diameter;
	    }
	}


	
	public boolean checkOutOfBounds(int screenBottomBorder) {
		if( y < screenBottomBorder) {
			return true;
		}
		return false;
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
