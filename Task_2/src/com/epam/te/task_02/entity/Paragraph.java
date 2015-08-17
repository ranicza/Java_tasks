package com.epam.te.task_02.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextComponent{
	
	private List<Sentence> parlist;
	
	public Paragraph(){
		parlist = new ArrayList<Sentence>();
	}
	
	@Override
	public TextComponent getTextComponent(int index){
		return parlist.get(index);
	}
	
	@Override
	public void addTextComponent(TextComponent component){
		if (component instanceof Sentence){
			parlist.add((Sentence) component);
		}
	}
	
	public void addTextComponentList(List<Sentence> component){
		parlist.addAll(component);
	}
	

	public List<Sentence> getSentences() {
		List<Sentence> list = new ArrayList<Sentence>();
 
		for (Sentence sen : parlist) {
			if (sen.getClass().equals(Sentence.class)) {
				list.add((Sentence) sen);
	        }
	    }
        return list;
	}

	
	@Override
	public String toString(){
	    StringBuilder result = new StringBuilder();
	    for (TextComponent element : parlist){
	    	result.append(element.toString());
	    }
	    return result.toString();
	}

	
}
