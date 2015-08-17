package com.epam.te.task_01.entity.fl;

public enum GreenhouseFlowerEnum {
	ROSE("white", "Amelia"), CHRISANTEMUM("red", "Fellbacher Wine"),
	LILY("white", "Snow-white");
	
	private final String color;
    private final String sort;
    
    GreenhouseFlowerEnum(String color, String sort){
		this.color = color;
		this.sort = sort;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String getSort(){
		return this.sort;
	}
}
