package brickBreakerGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {
	int x, y;
	int width, height;
	boolean destroyed;
	
	public Brick(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.destroyed = false;
	}
	
	public void paint(Graphics2D g) {
		if(!destroyed) {
			g.setColor(Color.white);
			g.fillRect(x, y, width, height);
		}
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
	public boolean isDestroyed() {
		return destroyed;
	}
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
}
