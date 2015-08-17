package com.epam.te.task_02.logic;

import java.util.List;

import com.epam.te.task_02.entity.PartOfSentence;
import com.epam.te.task_02.entity.Sentence;
import com.epam.te.task_02.entity.Text;
import com.epam.te.task_02.entity.Word;
import com.epam.te.task_02.exception.ParseException;

public class ChangeFLWord {
	/**
	 * Task 5
     * @return the text with changed the first and the last words in each sentence, 
     * without changing the length of the sentence.
     * @throws com.epam.te.task_02.exception.ParseException;
     */
	public static Text changeWords(Text text) throws ParseException {
        List<Sentence> list = text.getSentences();

        for (Sentence sentence : list) {
            List<Word> words = sentence.getWords();
            if (words.size() > 0) {
                Word first = words.get(0);
                Word last = words.get(words.size() - 1);

                List<PartOfSentence> parts = sentence.getSentenceList();

                int firstPosition = parts.indexOf(first);
                int lastPosition = parts.indexOf(last);

                parts.remove(lastPosition);
                parts.add(lastPosition, first);
                parts.remove(firstPosition);
                parts.add(firstPosition, last);

           }else{
        	   throw new ParseException("Exception in attempt to change the first and the last words in each sentence.\n "
        	   		+ "The list with words is empty!");
           }
       }
        return text;
   }
}

