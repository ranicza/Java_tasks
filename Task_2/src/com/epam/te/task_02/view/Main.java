package com.epam.te.task_02.view;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.te.task_02.entity.Text;
import com.epam.te.task_02.entity.TextComponent;
import com.epam.te.task_02.entity.Word;
import com.epam.te.task_02.exception.ParseException;
import com.epam.te.task_02.logic.ChangeFLWord;
import com.epam.te.task_02.logic.FindWord;
import com.epam.te.task_02.logic.WordSorter;
import com.epam.te.task_02.logic.parser.Parser;

public class Main {
	
	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void printText(Text text){
		for(TextComponent t : text.getTextList()){
			System.out.println(t.toString());
		}
	}
	
	
	public static void main(String[] args) throws ParseException{
		
		PropertyConfigurator.configure("src//resources//log4j.properties");
		
		String pathToText = "src//data//task2.txt";
		Parser parser = new Parser();
		Text text =parser.parse(pathToText);
		
		logger.info("THE PARSED TEXT:");
		printText(text);
		
		
		logger.info("TASK_3. UNIQUE WORDS FROM THE THIRD SENTENCE:");
		List<Word> words = FindWord.findWord(text);
		if(words.isEmpty()){
			logger.info("There are no unique words in this sentence!");
		}else{
			for(Word w : words){
				logger.info("Unigue word:\t" + w);
			}
		}	
		
		
		logger.info("TASK_5. TEXT AFTER CHANGING THE FIRST WORD WITH THE LAST ONE:");
		printText(ChangeFLWord.changeWords(text));
		
		
		logger.info("TASK_7. SORTED WORDS:");
		List<Word> sorted_words = WordSorter.sortWords(text);
		if(sorted_words.isEmpty()){
			logger.info("There are no sorted words in the text!");
		}else{
			for(Word word : sorted_words){
				logger.info(word);
			}
		}	
	}
}


