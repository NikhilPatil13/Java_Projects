// Answer entity class
package com.quiztaker.main.entity;

public class Answer {
	// data members
	private Integer ansId;
	private Integer ansQueId;// mapped by Question - queId 
	private Integer ansOptId;// mapped by Option - optId
	private Boolean isOptCorrect;
	private Integer ansPoints;

	
	// default constructor
	public Answer() {
	}


	// parameterized constructor
	public Answer(Integer ansId, Integer ansQueId, Integer ansOptId, Boolean isOptCorrect, Integer ansPoints) {
		this.ansId = ansId;
		this.ansQueId = ansQueId;
		this.ansOptId = ansOptId;
		this.isOptCorrect = isOptCorrect;
		this.ansPoints = ansPoints;
	}


	// setter getter methods
	public Integer getAnsId() {
		return ansId;
	}


	public void setAnsId(Integer ansId) {
		this.ansId = ansId;
	}


	public Integer getAnsQueId() {
		return ansQueId;
	}


	public void setAnsQueId(Integer ansQueId) {
		this.ansQueId = ansQueId;
	}


	public Integer getAnsOptId() {
		return ansOptId;
	}


	public void setAnsOptId(Integer ansOptId) {
		this.ansOptId = ansOptId;
	}


	public Boolean getIsOptCorrect() {
		return isOptCorrect;
	}


	public void setIsOptCorrect(Boolean isOptCorrect) {
		this.isOptCorrect = isOptCorrect;
	}


	public Integer getAnsPoints() {
		return ansPoints;
	}


	public void setAnsPoints(Integer ansPoints) {
		this.ansPoints = ansPoints;
	}


	// toString method
	@Override
	public String toString() {
		return "Answer [ansId=" + ansId + ", ansQueId=" + ansQueId + ", ansOptId=" + ansOptId + ", isOptCorrect="
				+ isOptCorrect + ", ansPoints=" + ansPoints + "]";
	}

}

