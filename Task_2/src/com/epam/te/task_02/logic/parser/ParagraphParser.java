package com.epam.te.task_02.logic.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.te.task_02.entity.Paragraph;
import com.epam.te.task_02.entity.Sentence;
import com.epam.te.task_02.exception.ParseException;

public class ParagraphParser extends Parser {
	private static final String PARAGRAPH = "paragraph";
	
	private ParagraphParser(){}
	
	private static class SingletonParagParser{
		private final static ParagraphParser INSTANCE = new ParagraphParser();
	}
	
	public static  ParagraphParser getInstance(){
		return SingletonParagParser.INSTANCE;
	}
	
	
	/**
     * Creates the list with paragraphs
     * @return the list with paragraphs
     * @throws com.epam.te.task_02.exception.ParseException;
     */
	public List<Paragraph> parseParagraph(String text) throws ParseException{
		String tmp = "";
		List<Paragraph> paragraph_list = new ArrayList<Paragraph>();
		List<Sentence> sentence_list;
		
		Pattern pattern = Pattern.compile(getRegex(PARAGRAPH)); 
		Matcher matcher = pattern.matcher(text);
		
		while (matcher.find()){ 
			tmp = matcher.group();
			Paragraph paragraph = new Paragraph();	
			sentence_list = SentenceParser.getInstance().parseSentence(tmp);
			
			paragraph.addTextComponentList(sentence_list);
			paragraph_list.add(paragraph);
		}		
		return paragraph_list;
	}
	
}
