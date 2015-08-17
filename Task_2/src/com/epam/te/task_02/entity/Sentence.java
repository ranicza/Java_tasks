package com.epam.te.task_02.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextComponent{
	private String parsedText;
	
	private List<PartOfSentence> senlist;
	
	public Sentence(){
		senlist = new ArrayList<PartOfSentence>();
	}
	
	@Override
	public TextComponent getTextComponent(int index){
		return senlist.get(index);
	}
	
	@Override
	public void addTextComponent(TextComponent component){
		if(component instanceof PartOfSentence){
			if(component instanceof Word){
				senlist.add((Word) component);
			}else if(component instanceof Punctuation){
				senlist.add((Punctuation) component);
			}
		}
	}
	
	public List<PartOfSentence> getSentenceList(){
		return this.senlist;
	}


	public List<Word> getWords() {
        List<Word> list = new ArrayList<Word>();

        for (PartOfSentence part :senlist) {
            if (part.getClass() == Word.class) {
                list.add((Word) part);
            }
        }
        return list;
    }
	
	public String getParsedText(){
		return this.parsedText;
	}
	
	@Override
	public String toString(){
	    StringBuilder result = new StringBuilder();
	    for(TextComponent element : senlist){
	        result.append(element.toString());
	    }
	    return result.toString();
	}
}
