package com.mdstech.workflow.type;

public enum MaritalStatusType {
	MARRIED("Married"),
	SEPARATED("Separated"),
	UNMARRIED("Un Married"),
	WIDOWED("Widowed");
	
	String desc;
	
	private MaritalStatusType(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
	@Override
	public String toString() {
		return desc;
	}	
}
