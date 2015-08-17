package com.epam.te.task_02.entity;

public class PartOfSentence implements TextComponent{
	
	private String a;
	
	public PartOfSentence(){}
	
	public PartOfSentence(String a){
		this.a = a;
	}
	
	@Override
	public TextComponent getTextComponent(int index){
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void addTextComponent(TextComponent component){
		throw new UnsupportedOperationException();
	}
	
	@Override
    public String toString() {
        return this.a;
    }
	

	@Override
	public boolean equals(Object ob){
	    if (this == ob){
	    	return true;
	    }
	    if (ob == null) {
	    	return false;
	    }
	    if (this.getClass() != ob.getClass()){
	    	return false;
	    }
	    PartOfSentence part = (PartOfSentence)ob;
	    if (a == null){
	    	return (a == part.a);
	    }else{
	    	if (!a.equals(part.a)){
	    		return false;
	    	}
	    }
	    return true;     
	}
	
	@Override
	public int hashCode() {
	    return (int)(31 *((a == null) ? 0 : a.hashCode()));
	}
}
