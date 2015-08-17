package com.epam.te.task_02.entity;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextComponent{
	
	private List<TextComponent> textlist;
	
	public Text(){
		textlist = new ArrayList<TextComponent>();
	}
	
	@Override
	public TextComponent getTextComponent(int index){
		return textlist.get(index);
	}
	
	@Override
	public void addTextComponent(TextComponent component){
		if(component instanceof Paragraph || component instanceof Code){
			textlist.add(component);
		}
	}
	
	public void addTextComponentList(List<Paragraph> component){
		textlist.addAll(component);
	}
	
	
	public List<TextComponent> getTextList(){
		return this.textlist;
	}
	

	public List<Paragraph> getParagraphs() {
		List<Paragraph> list = new ArrayList<Paragraph>();

	    for (TextComponent component : textlist) {
	    	if (component instanceof Paragraph) {
	    		list.add((Paragraph) component);
	        }
	    }
	    return list;
	}
	
	public List<Sentence> getSentences() {
	     List<Sentence> list = new ArrayList<Sentence>();

	     for (Paragraph paragraph : getParagraphs()) {
	    	 list.addAll(paragraph.getSentences());
	        }
	     return list;
	}

	
	@Override
	public String toString(){
        StringBuilder result = new StringBuilder();
        for(TextComponent element : textlist) {
            result.append(element.toString());
        }
        return  result.toString();
    }
	
}
