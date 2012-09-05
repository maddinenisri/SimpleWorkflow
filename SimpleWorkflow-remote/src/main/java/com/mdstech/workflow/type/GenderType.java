package com.mdstech.workflow.type;

public enum GenderType {
	F("Female"),
	M("Male");
	
	String gender;
	
	private GenderType(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
		
	@Override
	public String toString() {
		return gender;
	}
}