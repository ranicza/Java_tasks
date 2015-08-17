package com.epam.te.task_02.logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TextReader {
	
	/**
	* @return the string with the whole text
	*/
	public static String readText(String pathToText){
		String text = "";
		try (FileInputStream inFile = new FileInputStream(pathToText)){
			byte[] str = new byte[inFile.available()];
			inFile.read(str);
			text = new String(str);     
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
}
