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
	private static final long serialVersionUID = -1248101730864445577L;

	public SoundboardFrame()
	{
		super("Soundboard");
		this.initialize();			
	}
	
	private void initialize()
	{//Initialize the frame.
		//Frame properties
		this.setSize(800, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMenuBar(new MenuBar());
		
		//Menu bar for reset
		this.getMenuBar().add(new Menu("Reset to default..."));
		this.getMenuBar().getMenu(0).add(new MenuItem("Click here to reset"));
		this.getMenuBar().getMenu(0).getItem(0).addActionListener(new MenuActionListener());
		
		//Content pane and buttons
		this.setContentPane(new JPanel(new GridLayout(5, 5)));
		this.makeButtons();
	}
	
	public void makeButtons()
	{//There should be 5 rows of 5 buttons.
		this.getContentPane().removeAll();		
		SoundboardButton[][] buttons = new SoundboardButton[5][5];
		
		for(int y = 0; y < Main.NUMBER_BUTTONS_DOWN; y++)
			for(int x = 0; x < Main.NUMBER_BUTTONS_ACROSS; x++)
			{
				int button_number = y * 10 + x;
				GetFromFile getter = new GetFromFile(button_number);
				
				buttons[y][x] = new SoundboardButton(this, button_number, getter.getPath(), getter.getText());
				this.getContentPane().add(buttons[y][x]);
			}
		
		this.repaint();
		this.setVisible(true);
	}
	
	private class MenuActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{//When this happens, we want to refresh all the files and buttons
			Main.autoCheckFiles(true);
			makeButtons();
		}		
	}
}
