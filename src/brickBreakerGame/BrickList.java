package brickBreakerGame;

import java.awt.Graphics2D;
import java.util.Iterator;

public class BrickList {
	 public Brick[][] list;
	 int row,column;
	 int rowHeight = 0;
	 int rowWidthMultiplier;
	 public BrickList(int row, int column) {
		 this.row = row;
		 this.column = column;
		 list = new Brick[row][column];
		 for(int i = 0; i < list.length; i++) {
			 rowWidthMultiplier = 1;
			 rowHeight += 50;
			 for(int j = 0; j < list[i].length; j ++) {
					list[i][j] = new Brick(700 + (rowWidthMultiplier*50),280+(rowHeight),40,40);
					rowWidthMultiplier += 1;			
			 }
		 }		 	
	 }
	 public void draw(Graphics2D g) {
		 for(int i = 0; i < list.length; i ++) {
			 for(int j=0; j< list[i].length; j++) {
				 list[i][j].paint(g);
			 }
			 
		 }
	 }
	 public void remove(int i, int j) {
		 list[i][j] = new Brick(0,0,0,0);
}
	 public int getBricksAmount() {
		 return row*column;
	 }
	 };
