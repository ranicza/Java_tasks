package com.epam.te.task_02.entity;

public class Word extends PartOfSentence{
	private String a;
	
	public Word(String a){
		this.a = a;
	}
	
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
	    Word w = (Word)ob;
	    if (a == null){
	    	return (a == w.a);
	    }else{
	    	if (!a.equals(w.a)){
	    		return false;
	    	}
	    }
	    return true;     
	}
	
	public int hashCode() {
		return (int)(37 *((a == null) ? 0 : a.hashCode()));
	}
	
	
	@Override
	public String toString(){
		return this.a;
	}
	
}
