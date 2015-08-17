package com.epam.te.task_01.entity.accessory;

public abstract class Accessory {
	private String name;
	private String color;
	
	public Accessory(){}
	
	public Accessory(String name, String color){
		this.name = name;
		this.color = color;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setColor(String color){
		this.color = color;
	}
	public String getColor(){
		return this.color;
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
	    Accessory tmp = (Accessory)ob;
	    if (name == null){
	    	return (name == tmp.name);
	    }else{
	    	if (!name.equals(tmp.name)){
	    		return false;
	    	}
	    }
	    if (color == null){
	    	return (color == tmp.color);
	    }else{
	    	if (!color.equals(tmp.color)){
	    		return false;
	    	}
	    }
	    return true;     
	}
	
	
	public int hashCode() {
	    return (int)(31 * (((name == null) ? 0 : name.hashCode()) + ((color == null) ? 0 : color.hashCode())));
	}
	
	public String toString(){
		return getClass().getName() + " @name: " + name + ", color: " + color;
	}
}
