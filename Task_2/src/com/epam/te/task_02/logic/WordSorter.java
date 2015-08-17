package com.epam.te.task_02.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.te.task_02.entity.Sentence;
import com.epam.te.task_02.entity.Text;
import com.epam.te.task_02.entity.Word;

public class WordSorter {
	
	/**
	 * Task 7
     * Sorts the words from the text by the ratio of the vowels characters
     * to the total number of characters in a word in ascending order
     * @return the list with words
	 * @throws com.epam.te.task_02.exception.ParseException;
     */

	public static List<Word> sortWords(Text text){
		List<Sentence> sentence_list = text.getSentences();
		List<Word> sortedWords = new ArrayList<Word>();
		
		for (Sentence sentence : sentence_list) {
            List<Word> words = sentence.getWords();
            if (words.size() > 0) { 
            	for (Word word : words){
            		sortedWords.add((Word)word);
            	}
            }
		}
		
		Collections.sort(sortedWords, new WordComparator());

		return sortedWords;
	}
}
