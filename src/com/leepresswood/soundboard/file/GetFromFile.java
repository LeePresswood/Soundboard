package com.leepresswood.soundboard.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.leepresswood.soundboard.Main;

public class GetFromFile
{
	private String path;
	private String text;
	
	public GetFromFile(int button_number)
	{//Read from the file for the particular button to get the path and text
		File file = new File(Main.FILE_PATH_FRONT + button_number + Main.FILE_EXTENSION);
		try
		{//Collect the two lines.			
			BufferedReader reader = new BufferedReader(new FileReader(file));			
			path = reader.readLine();
			text = reader.readLine();	
			reader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public String getPath()
	{
		return this.path;
	}

	public String getText()
	{
		return this.text;
	}
}
