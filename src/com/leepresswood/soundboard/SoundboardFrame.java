package com.leepresswood.soundboard;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundboardFrame extends JFrame
{
	public SoundboardFrame()
	{
		super("Soundboard");
		this.setSize(1080, 720);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new JPanel());
		this.makeButtons();
		//this.pack();
		this.setVisible(true);
	}
	
	private void makeButtons()
	{//There should be 5 rows of 5 buttons.
		SoundboardButton[][] buttons = new SoundboardButton[5][5];
		
		for(int y = 0; y < 5; y++)
			for(int x = 0; x < 5; x++)
			{
				buttons[y][x] = new SoundboardButton();
				this.getContentPane().add(buttons[y][x]);
			}
	}
}
