package com.epam.te.task_02.logic.parser;

import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.te.task_02.entity.Code;
import com.epam.te.task_02.entity.Paragraph;
import com.epam.te.task_02.entity.Text;
import com.epam.te.task_02.exception.ParseException;
import com.epam.te.task_02.logic.TextReader;

public class Parser {
	private static final String BUNDLE_RESOURCES = "resources.text";
	private static final String CODE = "code";
private ResourceBundle rb;
	
	public Parser(){
		rb = ResourceBundle.getBundle(BUNDLE_RESOURCES);
	}
	
	
	/**
	* @return string with regex from ResourseBundle
	*/
	public String getRegex(String regex){
		return rb.getString(regex);
	}
	
	/**
     * Creates the Text object.
     * @return parsed text
     * @throws com.epam.te.task_02.exception.ParseException;
     */
	public Text parse(String pathToText) throws ParseException{
		String tmp = "";
		Text text = new Text();
		List<Paragraph> list_paragraph;

		String text_string = TextReader.readText(pathToText);
		
		Pattern pattern = Pattern.compile(getRegex(CODE)); 
		Matcher matcher = pattern.matcher(text_string);
		
		String temp_original_str = text_string;
		String nextPart = text_string;
		
		while(matcher.find()){
			tmp = matcher.group();
			if (nextPart.indexOf(tmp) > 0){
				temp_original_str = nextPart.substring(0, nextPart.indexOf(tmp));
				nextPart = text_string.substring(text_string.indexOf(tmp) + tmp.length());
			}
			list_paragraph = ParagraphParser.getInstance().parseParagraph(temp_original_str);
			
			text.addTextComponentList(list_paragraph);
			text.addTextComponent(new Code(tmp));
		}
		list_paragraph = ParagraphParser.getInstance().parseParagraph(nextPart);
		
		text.addTextComponentList(list_paragraph);
		return text;
	}
}
		


