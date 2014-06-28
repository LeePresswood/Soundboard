package com.leepresswood.soundboard.button;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class SoundboardButton extends JButton
{
	private int button_number;
	private File old_file;
	private File new_file;
	private String old_text;
	private String new_text;
	
	
	public SoundboardButton(int button_number)
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
		
		//this.setText(text);
	}
	
	private void onRightClick()
	{		
		JDialog dialog = new JDialog();
		dialog.setResizable(false);
		dialog.setSize(new Dimension(500, 350));
		dialog.setPreferredSize(dialog.getSize());
		dialog.setMinimumSize(dialog.getSize());
		dialog.setContentPane(new JPanel(new GridLayout(2, 3, 0, 3)));
		
		//File Chooser Row		
		final JTextArea file_field = new JTextArea();
		JButton file_button = new JButton("...");			
		file_button.addActionListener(new ActionListener()
		{			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{//Open a file chooser dialog.
				final JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(SoundboardButton.this);
				if(fc.getSelectedFile() != null)
				{
					file_field.setText(fc.getSelectedFile().toPath().toString());
					new_file = fc.getSelectedFile();
				}
			}
		});	
		dialog.getContentPane().add(new JLabel("Sound File:"));
		dialog.getContentPane().add(file_field);
		dialog.getContentPane().add(file_button);
				
		//Button Text Row
		final JTextArea text_field = new JTextArea();
		JButton text_button = new JButton("Confirm Changes");
		text_button.addActionListener(new ActionListener()
		{			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{//Confirmation button. Replace saved file and saved text with the new ones.
				
			}
		});		
		dialog.getContentPane().add(new JLabel("Button Text:"));
		dialog.getContentPane().add(text_field);
		dialog.getContentPane().add(text_button);
		
		dialog.setVisible(true);
	}
	
	private void onLeftClick()
	{
		
	}
}
