// Option entity class
package com.quiztaker.main.entity;

public class Option {
	// data members
	private Integer optId;
	private String optStatement;
	private Boolean isOptCorrect;
	private Integer optQueId;// mapped by Question - queId
	
	// default constructor
	public Option() {
	}

	// parameterized constructor
	public Option(Integer optId, String optStatement, Boolean isOptCorrect, Integer optQueId) {
		this.optId = optId;
		this.optStatement = optStatement;
		this.isOptCorrect = isOptCorrect;
		this.optQueId = optQueId;
	}

	// setter getter methods
	public Integer getOptId() {
		return optId;
	}

	public void setOptId(Integer optId) {
		this.optId = optId;
	}

	public String getOptStatement() {
		return optStatement;
	}

	public void setOptStatement(String optStatement) {
		this.optStatement = optStatement;
	}

	public Boolean getIsOptCorrect() {
		return isOptCorrect;
	}

	public void setIsOptCorrect(Boolean isOptCorrect) {
		this.isOptCorrect = isOptCorrect;
	}

	public Integer getOptQueId() {
		return optQueId;
	}

	public void setOptQueId(Integer optQueId) {
		this.optQueId = optQueId;
	}

	// toString method
	@Override
	public String toString() {
		return "Option [optId=" + optId + ", optStatement=" + optStatement + ", isOptCorrect=" + isOptCorrect
				+ ", optQueId=" + optQueId + "]";
	}
}
