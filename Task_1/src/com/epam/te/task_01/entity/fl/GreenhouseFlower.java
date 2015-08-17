package com.epam.te.task_01.entity.fl;

public class GreenhouseFlower extends Flower{
	private String sort;
	
	public GreenhouseFlower(String name, int length){
		super(name, length);
		super.setColor(GreenhouseFlowerEnum.valueOf(name.toUpperCase()).getColor());
		this.sort = GreenhouseFlowerEnum.valueOf(name.toUpperCase()).getSort();
	}
	
	public String getSort(){
		return this.sort;
	}
	
	public boolean equals (Object ob){
	    if (this == ob) {
	    	return true;
	    }
	    if (ob == null) {
	    	return false;
	    }
	    if (this.getClass() != ob.getClass()){
	    	return false;
	    }
	    GreenhouseFlower tmp = (GreenhouseFlower)ob;
	    if (!super.equals(tmp)){
	    	return false;
	    }
	    if (sort == null){
	    	return (sort == tmp.sort);
	    }else{
	    	if (!sort.equals(tmp.sort)){
	    		return false;
	    	}
	    }
	    return true;
	 }
	
	public int hashCode() {
		   return (int)(super.hashCode() + ((sort == null) ? 0 : sort.hashCode()));
	}
	
	public String toString(){
		return super.toString() + ", sort: " + this.getSort();
	}
}
