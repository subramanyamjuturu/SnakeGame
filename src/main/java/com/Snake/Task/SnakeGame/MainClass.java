package com.Snake.Task.SnakeGame;

import java.awt.Color;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {

		JFrame gameChart = new JFrame();
		GameProperties game= new GameProperties();
		// layout of the game
		gameChart.setBounds(10, 10, 905, 700);
		// Setting color
		gameChart.setBackground(Color.DARK_GRAY);
		// For not changing size of the game
		gameChart.setResizable(false);
		// For visiblity of  game
		gameChart.setVisible(true);
		//For closing of the window
		gameChart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Adding the object of the game play to the object of the gamechart
		gameChart.add(game);
	}

}
