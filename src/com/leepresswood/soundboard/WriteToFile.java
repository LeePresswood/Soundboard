package com.leepresswood.soundboard;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WriteToFile
{//Collect the information to write to a file
	public WriteToFile(Integer button_num, String new_path, String new_text)
	{
		//Get the path
		String path = "files/" + button_num.toString() + ".sf";
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter(path, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		writer.println(new_path);
		writer.println(new_text);
		writer.close();
	}
}
