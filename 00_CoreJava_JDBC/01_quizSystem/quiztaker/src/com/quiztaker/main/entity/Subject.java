package com.quiztaker.main.entity;

public class Subject {
	// data members
	private Integer subId;
	private String subName;
	
	// default constructor	
	public Subject() {
	}

	
	// parameterized constructor
	public Subject(Integer subId, String subName) {
		this.subId = subId;
		this.subName = subName;
	}


	// setter getter
	public Integer getSubId() {
		return subId;
	}


	public void setSubId(Integer subId) {
		this.subId = subId;
	}


	public String getSubName() {
		return subName;
	}


	public void setSubName(String subName) {
		this.subName = subName;
	}
		
}
