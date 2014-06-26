package com.leepresswood.soundboard;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SoundboardButton extends JButton
{
	public int button_number;
	public File new_file;
	
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
		//File chooser
		final JTextArea field = new JTextArea(5,20);
		JButton file_button = new JButton("...");
		final JFileChooser fc = new JFileChooser();		
		//fc.showDialog(sb, "Hi");
		file_button.addActionListener(new ActionListener()
		{			
			@Override
			public 
			void actionPerformed(ActionEvent arg0)
			{
				fc.showOpenDialog(SoundboardButton.this);
				field.setText(fc.getSelectedFile().toPath().toString());
				new_file = fc.getSelectedFile();
			}
		});
		
		JDialog dialog = new JDialog();
		dialog.setSize(new Dimension(500, 350));
		dialog.setPreferredSize(dialog.getSize());
		dialog.setMinimumSize(dialog.getSize());
		dialog.setContentPane(new JPanel());
		dialog.add(new JLabel("Sound File:"));
		dialog.add(field);
		dialog.add(new JButton("..."));
		dialog.setVisible(true);
	}
	
	private void onLeftClick()
	{
		
	}
}
