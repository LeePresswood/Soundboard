package com.leepresswood.soundboard;

import java.io.File;
import com.leepresswood.soundboard.file.WriteToFile;

public class Main
{
	public static final int NUMBER_BUTTONS_ACROSS = 5;
	public static final int NUMBER_BUTTONS_DOWN = 5;
	
	public static final String FILE_PATH_FRONT = "files/";
	public static final String FILE_EXTENSION = ".sf";
	
	public static final String DEFAULT_PATH = "C://";
	public static final String DEFAULT_BUTTON_TEXT = "Right click to change.";
	
	public static void main(String[] args)
	{
		//Auto-check to see we have all files
		for(int y = 0; y < NUMBER_BUTTONS_DOWN; y++)
			for(int x = 0; x < NUMBER_BUTTONS_ACROSS; x++)
			{
				int button_num = y * 10 + x;
				File file = new File(FILE_PATH_FRONT + button_num + FILE_EXTENSION);
				if(!file.exists())
					new WriteToFile(button_num, DEFAULT_PATH, DEFAULT_BUTTON_TEXT);
			}
		
		//Create the board
		SoundboardFrame board = new SoundboardFrame();
	}
}
