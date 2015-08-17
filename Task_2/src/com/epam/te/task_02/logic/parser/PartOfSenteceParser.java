package com.epam.te.task_02.logic.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.te.task_02.entity.Punctuation;
import com.epam.te.task_02.entity.Sentence;
import com.epam.te.task_02.entity.Word;
import com.epam.te.task_02.exception.ParseException;


public class PartOfSenteceParser extends Parser{
	private static final String WORD_PUNCTUATION = "word&punctuation";
	private static final String WORD = "word";

	private PartOfSenteceParser(){}
	
	private static class SingletonPartSentParser{
		private final static PartOfSenteceParser INSTANCE = new PartOfSenteceParser();
	}
	
	public static PartOfSenteceParser getInstance(){
		return SingletonPartSentParser.INSTANCE;
	}
	
	/**
     * Creates the list with words and punctuation
     * @return the list with parts of sentence
     * @throws com.epam.te.task_02.exception.ParseException;
     */
	public void parsePartOfSentence(String paragraph_str, Sentence sentence) throws ParseException{
		String tmp = "";
		Pattern pattern = Pattern.compile(getRegex(WORD_PUNCTUATION)); 
		Matcher matcher = pattern.matcher(paragraph_str);
		
		while (matcher.find()) {
			tmp = matcher.group();
			if (tmp.matches(getRegex(WORD))){
				sentence.addTextComponent(new Word(tmp));
			} else {
				sentence.addTextComponent(new Punctuation(tmp));
			}
			
        }
	}
}
