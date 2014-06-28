package com.leepresswood.soundboard.button;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import com.leepresswood.soundboard.SoundboardFrame;
import com.leepresswood.soundboard.file.WriteToFile;

public class SoundboardButton extends JButton
{
	private static final long serialVersionUID = 8557918897168857910L;
	
	private int button_number;
	private String file;
	private String text;
	private SoundboardFrame frame;
		
	public SoundboardButton(SoundboardFrame frame, int button_number, String button_path, String button_text)
	{
		//Grab variables
		this.frame = frame;
		this.button_number = button_number;
		this.file = button_path;
		this.text = button_text;
		
		//Create button
		this.setText(this.text);
		this.addMouseListener(new MouseListenerButtonClass());
	}
	
	private void onRightClick()
	{		
		final JDialog dialog = new JDialog();
		dialog.setSize(new Dimension(700, 500));
		dialog.setResizable(false);		
		dialog.setPreferredSize(dialog.getSize());
		dialog.setMinimumSize(dialog.getSize());
		dialog.setContentPane(new JPanel(new GridLayout(2, 3, 0, 3)));
		
		//File Chooser Row		
		final JTextArea file_field = new JTextArea(this.file);
		file_field.setEditable(false);
		file_field.setLineWrap(true);
		JButton file_button = new JButton("...");			
		file_button.addActionListener(new ActionListener()
		{			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{//Open a file chooser dialog.
				final JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
				fc.showOpenDialog(SoundboardButton.this);
				if(fc.getSelectedFile() != null)
				{
					file_field.setText(fc.getSelectedFile().toPath().toString());
					file = fc.getSelectedFile().toPath().toString();
				}
			}
		});	
		dialog.getContentPane().add(new JLabel("Sound File:"));
		dialog.getContentPane().add(file_field);
		dialog.getContentPane().add(file_button);
				
		//Button Text Row
		final JTextArea text_field = new JTextArea(this.text);
		JButton text_button = new JButton("Confirm Changes");
		text_button.addActionListener(new ActionListener()
		{			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{//Confirmation button. Replace saved file and saved text with the new ones.
				text = text_field.getText();
				new WriteToFile(button_number, file, text);
				
				dialog.setVisible(false);
				frame.makeButtons();
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
	
	private class MouseListenerButtonClass implements MouseListener
	{//Create the mouse listener that handles right and left clicks
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
		}

		@Override
		public void mouseEntered(MouseEvent arg0)
		{
		}

		@Override
		public void mouseExited(MouseEvent arg0)
		{
		}

		@Override
		public void mousePressed(MouseEvent arg0)
		{
			if(arg0.getButton() == MouseEvent.BUTTON1)
				onLeftClick();
			else if(arg0.getButton() == MouseEvent.BUTTON3)
				onRightClick();
		}

		@Override
		public void mouseReleased(MouseEvent arg0)
		{
		}		
	}
}
