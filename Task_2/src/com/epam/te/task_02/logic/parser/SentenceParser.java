package com.epam.te.task_02.logic.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.te.task_02.entity.Sentence;
import com.epam.te.task_02.exception.ParseException;

public class SentenceParser extends Parser{
	private static final String SENTENCE = "sentence" ;
	
	private SentenceParser(){}
	
	private static class SingletonSenParser{
		private final static SentenceParser INSTANCE = new SentenceParser();
	}
	
	public static SentenceParser getInstance(){
		return SingletonSenParser.INSTANCE;
	}
	
	
	/**
     * Creates the list with sentences
     * @return the list with sentences
     * @throws com.epam.te.task_02.exception.ParseException;
     */
	public List<Sentence> parseSentence(String paragraph_str) throws ParseException{
		String tmp = "";
		List<Sentence> sentence_list = new ArrayList<Sentence>();
		
		Pattern pattern = Pattern.compile(getRegex(SENTENCE)); 
		Matcher matcher = pattern.matcher(paragraph_str);
		
		while (matcher.find()) {
			tmp = matcher.group();
			Sentence sentence = new Sentence();
			
			PartOfSenteceParser.getInstance().parsePartOfSentence(tmp, sentence);
			sentence_list.add(sentence);
		}
        return sentence_list;
    }
	
}
