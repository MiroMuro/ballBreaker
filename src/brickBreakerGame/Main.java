package brickBreakerGame;

import java.awt.Color;

import javax.swing.JFrame;

public class Main  {
	public static void main(String[] args) {
		Game game = new Game();
		JFrame mainFrame = new JFrame();
		mainFrame.setBounds(0, 0, 1920, 1080);
		mainFrame.setTitle("Ball breaker");
		mainFrame.setVisible(true);
		mainFrame.setResizable(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(game);
		
	}
	
	
}
