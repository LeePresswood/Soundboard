package com.leepresswood.soundboard;

import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.leepresswood.soundboard.button.SoundboardButton;
import com.leepresswood.soundboard.file.GetFromFile;

public class SoundboardFrame extends JFrame
{
	public SoundboardFrame()
	{
		super("Soundboard");
		this.setSize(1080, 720);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMenuBar(new MenuBar());
		this.getMenuBar().add(new Menu("Reset to default..."));
		this.getMenuBar().getMenu(0).add(new MenuItem("Click here to reset"));
		this.getMenuBar().getMenu(0).getItem(0).addActionListener(new MenuActionListener());
		this.setContentPane(new JPanel(new GridLayout(5, 5)));
		this.makeButtons();
		this.setVisible(true);
	}
	
	private void makeButtons()
	{//There should be 5 rows of 5 buttons.
		SoundboardButton[][] buttons = new SoundboardButton[5][5];
		
		for(int y = 0; y < Main.NUMBER_BUTTONS_DOWN; y++)
			for(int x = 0; x < Main.NUMBER_BUTTONS_ACROSS; x++)
			{
				int button_number = y * 10 + x;
				GetFromFile getter = new GetFromFile(button_number);
				
				buttons[y][x] = new SoundboardButton(button_number, getter.getPath(), getter.getText());
				this.getContentPane().add(buttons[y][x]);
			}
	}
	
	private class MenuActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{//When this happens, we want to refresh all the files
			Main.autoCheckFiles(true);
		}		
	}
}
