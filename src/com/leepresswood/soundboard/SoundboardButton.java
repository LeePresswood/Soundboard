package com.leepresswood.soundboard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class SoundboardButton extends JButton
{
	public int button_number;
	
	public SoundboardButton(int button_number, String text)
	{
		this.button_number = button_number;
		
		//Create the mouse listener that handles right and left clicks
		this.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent arg0){}
			
			@Override
			public void mousePressed(MouseEvent arg0)
			{
				if(arg0.getButton() == MouseEvent.BUTTON1)
					onLeftClick();
				else if(arg0.getButton() == MouseEvent.BUTTON3)
					onRightClick();
			}
			
			@Override
			public void mouseExited(MouseEvent arg0){}
			
			@Override
			public void mouseEntered(MouseEvent arg0){}
			
			@Override
			public void mouseClicked(MouseEvent arg0){}
		});
		
		this.setText(text);
	}
	
	private void onRightClick()
	{
		JOptionPane.showInputDialog("Test");
	}
	
	private void onLeftClick()
	{
		
	}
}
