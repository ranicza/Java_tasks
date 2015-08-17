package com.epam.te.task_02.logic;

import java.util.ArrayList;
import java.util.List;

import com.epam.te.task_02.entity.Sentence;
import com.epam.te.task_02.entity.Text;
import com.epam.te.task_02.entity.Word;
import com.epam.te.task_02.exception.ParseException;

public class FindWord {
	/**
	 * Task 3
     * Creates the list with unique words from the first sentence,
     * which doesn't exist in other sentences.
     * @return the list with words
	 * @throws com.epam.te.task_02.exception.ParseException;
     */
	public static List<Word> findWord(Text text) throws ParseException{
		List<Sentence> sentence_list = text.getSentences();
		
		Sentence third = sentence_list.get(2);  				 // Беру 3-ее предложение,т.к. первые два являются заголовками
		List<Word> unique_words = new ArrayList<Word>();
		sentence_list.remove(third);
		
		if(sentence_list.size() > 0){
			for (Word word : third.getWords()){	
				if(searchWord(word, sentence_list)){
					unique_words.add(word);
				}
			}
		}else{
			throw new ParseException("Exception in attempt to find unique words.\n The list with sentences is empty!");
		}
		return unique_words;
	} 
	
	
	private static boolean searchWord(Word word, List<Sentence> sentence_list) {
		int count = 0;
		boolean isWordRepeat;
	    for (Sentence sentence : sentence_list) {  	
	    	
	    	for (Word currentWord : sentence.getWords()) { 		
	    		if (currentWord.toString().equals(word.toString())) {
	    			count++;
	            }
	        }        	      
	    }
	    if(count == 0){
	    	isWordRepeat = true;
	    }else{
	    	isWordRepeat =  false;
	    }
	    return isWordRepeat;
	}
}

