package com.epam.te.task_02.entity;

public class Code implements TextComponent{
	
	private String code_string;
	
	public Code(String code_string){
		this.code_string = code_string;
	}
	
	public String getCode_string(){
		return this.code_string;
	}

	@Override
	public TextComponent getTextComponent(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addTextComponent(TextComponent component) {
		throw new UnsupportedOperationException();
		
	}
	
	@Override
    public String toString() {
        return code_string;
    }
}
