package com.Snake.Task.SnakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameProperties extends JPanel implements KeyListener,ActionListener{

	private ImageIcon titleImage;

	// For snake length
	private int [] snakexlength = new int [750];
	private int [] snakeylength = new int [750];

	// For snake directions
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;

	// For snake moving
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;

	// For snake moving
	private Timer timer;
	private int delay = 100;

	private int lengthOfsnake =3;

	// For snake

	private ImageIcon snakeimage;
	
	private int [] enemyxpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425
			,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	
	private int [] enemyypos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425
			,450,475,500,525,550,575,600,625};
	
	private ImageIcon enemyimage;
	
	private Random random = new Random();
	
	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);
	
	private int score = 0;


	public int moves =0;


	public GameProperties()
	{
		addKeyListener(this);
		setFocusable(true);
		setRequestFocusEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint(Graphics g)
	{

		// code for snake position if game ist started
		if(moves ==0)
		{
			snakexlength [2] = 50;
			snakexlength [1] = 75;
			snakexlength [0] = 100;

			snakeylength [2] = 100;
			snakeylength [1] = 100;
			snakeylength [0] = 100;
		}
		// Draw Title Image borders
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);

		// Draw the title Image
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);	

		// Draw border for game
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);

		// Draw background for the gameplay
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);
		
		// draw scores
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN,14));
		g.drawString("Score :"+score, 780, 30);
		
		// draw length of scores
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN,14));
		g.drawString("Length :"+lengthOfsnake, 780, 50);

		// For default position of the snake
		rightmouth = new ImageIcon("rightmouth.jpg");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

		for(int i=0;i < lengthOfsnake;i++)
		{
			if(i==0 && right)
			{
				rightmouth = new ImageIcon("rightmouth.jpg");
				rightmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);

			}
			if(i==0 && left)
			{
				leftmouth = new ImageIcon("leftmouth.jpg");
				leftmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);

			}
			if(i==0 && up)
			{
				upmouth = new ImageIcon("upmouth.jpg");
				upmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);

			}
			if(i==0 && down)
			{
				downmouth = new ImageIcon("downmouth.jpg");
				downmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);

			}

			if(i!=0)
			{
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
		}
		
		enemyimage = new ImageIcon("enemy.png");
		
		if((enemyxpos[xpos] == snakexlength[0] && enemyypos[ypos] == snakeylength[0]))
		{
			score++;
			lengthOfsnake++;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}
		
		enemyimage.paintIcon(this, g, enemyxpos[xpos],  enemyypos[ypos]);
		
		for(int i=1;i< lengthOfsnake;i++)
		{
			if(snakexlength[i] == snakexlength[0] && snakeylength[i] == snakeylength[0])
			{
				right = false;
				left = false;
				up = false;
				down = false;
				
				g.setColor(Color.WHITE);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("GAME OVER", 300, 300);
				
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Press Space to Restart Game", 350, 340);
			}
		}

		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {

		timer.start();
		if(right)
		{

			for(int r = lengthOfsnake-1; r>=0; r--)
			{
				snakeylength[r+1] = snakeylength[r];

			}

			for(int r = lengthOfsnake; r>=0; r--)
			{
				if(r==0)
				{
					snakexlength[r] = snakexlength[r] + 25;
				}
				else
				{
					snakexlength[r] = snakexlength[r-1];
				}

				if(snakexlength[r]>850)
				{
					snakexlength[r] = 25;
				}
			}
			repaint();
		}
		if(left)
		{
			for(int r = lengthOfsnake-1; r>=0; r--)
			{
				snakeylength[r+1] = snakeylength[r];

			}

			for(int r = lengthOfsnake; r>=0; r--)
			{
				if(r==0)
				{
					snakexlength[r] = snakexlength[r] - 25;
				}
				else
				{
					snakexlength[r] = snakexlength[r-1];
				}

				if(snakexlength[r] < 25)
				{
					snakexlength[r] = 850;
				}
			}
			repaint();

		}
		if(up)
		{
			for(int r = lengthOfsnake-1; r>=0; r--)
			{
				snakexlength[r+1] = snakexlength[r];

			}

			for(int r = lengthOfsnake; r>=0; r--)
			{
				if(r==0)
				{
					snakeylength[r] = snakeylength[r] - 25;
				}
				else
				{
					snakeylength[r] = snakeylength[r-1];
				}

				if(snakeylength[r] < 75)
				{
					snakeylength[r] = 625;
				}
			}
			repaint();
		}
		if(down)
		{
			for(int r = lengthOfsnake-1; r>=0; r--)
			{
				snakexlength[r+1] = snakexlength[r];

			}

			for(int r = lengthOfsnake; r>=0; r--)
			{
				if(r==0)
				{
					snakeylength[r] = snakeylength[r] + 25;
				}
				else
				{
					snakeylength[r] = snakeylength[r-1];
				}

				if(snakeylength[r] > 625)
				{
					snakeylength[r] = 75;
				}
			}
			repaint();
		}
	}

	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			moves= 0;
			score= 0;
			lengthOfsnake = 3;
			repaint();
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moves++;
			right =true;
			if(!left)
			{
				right = true;
			}
			else
			{
				right = false;
				left = true;
			}
			up = false;
			down = false;

		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moves++;
			left =true;
			if(!right)
			{
				left = true;
			}
			else
			{
				left = false;
				right = true;
			}
			up = false;
			down = false;

		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moves++;
			down =true;
			if(!up)
			{
				down = true;
			}
			else
			{
				down = false;
				up = true;
			}
			right = false;
			left = false;

		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moves++;
			up =true;
			if(!down)
			{
				up = true;
			}
			else
			{
				up = false;
				down = true;
			}
			right = false;
			left = false;

		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
