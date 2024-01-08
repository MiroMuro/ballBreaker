package brickBreakerGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
	private int x,y;
	private int width,height;
	private int speed;
	
	public Paddle(int x, int y, int width, int height, int speed) {
		this.x =x;
		this.y =y;
		this.width = width;
		this.height= height;
		this.speed = speed;
	}
	
	public void moveRight() {
		x += speed; 
	}
	public void moveLeft() {
		x -= speed;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,width, height);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x,y,width,height);		
	}
	public int getX() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	
	
	
}
