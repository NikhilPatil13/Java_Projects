// question entity class
package com.quiztaker.main.entity;


public class Question {
	// data members
	private Integer queId;
	private String queStatement;
	private Integer quePoints;
	
	// one question have one subject
	private Integer queSubjectId;

	
	// default constructor
	public Question() {
	}


	// parameterized constructor
	public Question(Integer queId, String queStatement, Integer quePoints, Integer queSubjectId) {
		this.queId = queId;
		this.queStatement = queStatement;
		this.quePoints = quePoints;
		this.queSubjectId = queSubjectId;
	}


	// setter getter methods
	public Integer getQueId() {
		return queId;
	}


	public void setQueId(Integer queId) {
		this.queId = queId;
	}


	public String getQueStatement() {
		return queStatement;
	}


	public void setQueStatement(String queStatement) {
		this.queStatement = queStatement;
	}


	public Integer getQuePoints() {
		return quePoints;
	}


	public void setQuePoints(Integer quePoints) {
		this.quePoints = quePoints;
	}
	
	public Integer getQueSubjectId() {
		return queSubjectId;
	}


	public void setQueSubjectId(Integer queSubjectId) {
		this.queSubjectId = queSubjectId;
	}
	

	// toString method
	@Override
	public String toString() {
		return "Question [queId=" + queId + ", queStatement=" + queStatement + ", quePoints=" + quePoints
				+ ", queSubjectId=" + queSubjectId + "]";
	}

}
