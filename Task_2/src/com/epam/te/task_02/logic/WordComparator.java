package com.epam.te.task_02.logic;

import java.util.Comparator;
import java.util.HashSet;

import com.epam.te.task_02.entity.Word;

public class WordComparator implements Comparator<Word>{
		
	private static HashSet<Character> vowels = new HashSet<>();
	
	{
		char[] vowel_letter = {'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};	
		for(char c: vowel_letter){
			vowels.add(c);
		}			
	}

	@Override
	public int compare(Word o1, Word o2) {	
		double ratio1 = ratio(o1);
		double ratio2 = ratio(o2);
			
		if (ratio1 > ratio2){
			return 1;
		} else if(ratio2 > ratio1){
			return -1;
		}		
		return 0;
	}
		
	
	/**
	* Calculates ratio (vowels count / characters count)
	* @param word
	* @return ratio
	*/
	private double ratio(Word word){
		int size = word.toString().length();
		int found = 0;
		for(int i = 0; i < size; i++){
			if (vowels.contains(word.toString().charAt(i))){
				found++;
			}
		}		
		return (double) found/size;
	}
}
