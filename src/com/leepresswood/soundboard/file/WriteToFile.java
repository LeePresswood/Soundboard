package com.leepresswood.soundboard.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WriteToFile
{//Collect the information to write to a file. Write it and close.
	public WriteToFile(Integer button_num, String new_path, String new_text)
	{
		//Get the path
		String path_to_file = "files/" + button_num.toString() + ".sf";
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter(path_to_file, "UTF-8");
			writer.println(new_path);
			writer.println(new_text);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}		
	}
}
