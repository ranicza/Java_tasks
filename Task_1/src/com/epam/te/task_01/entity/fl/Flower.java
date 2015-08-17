package com.epam.te.task_01.entity.fl;

public abstract class Flower {
	private String name;
	private String color;
	private int length;
	private Freshness myFreshness;
		
	public Flower(String name, int length){
		this.name  = name;
		this.length = length; 
		this.myFreshness = Freshness.getMyFreshness();
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setLength(int length){
		this.length = length;
	}
	
	public int getLength(){
		return this.length;
	}
	
	public Freshness getFreshness(){
		return this.myFreshness;
	}
	
	public int getTotalFresh(){
		switch(this.getFreshness()){
		case FRESH: return  3;
		case MIDDLE: return  2;
		case OLD: return 1 ;
		}return 0;
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
	    Flower flower = (Flower)ob;
	    if (name == null){
	    	return (name == flower.name);
	    }else{
	    	if (!name.equals(flower.name)){
	    		return false;
	    	}
	    }
	    if (color == null){
	    	return (color == flower.color);
	    }else{
	    	if (!color.equals(flower.color)){
	    		return false;
	    	}
	    }
	    if (length!= flower.length){
	    	return false;
	    }
	    if (!myFreshness.equals(flower.myFreshness)){
	    	return false;
	    }
	    return true;     
	}
	
	public int hashCode() {
	    return (int)(31 * length + ((name == null) ? 0 : name.hashCode()) + myFreshness.hashCode() + 
	    		((color == null) ? 0 : color.hashCode()));
	}
	
 	public String toString(){
		return getClass().getName() + ", @name: " + name + ", color: " + color + ", length: " + length + ", myFreshness: " + myFreshness;
	}

}
