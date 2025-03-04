// Quiz entity class
package com.quiztaker.main.entity;



public class Quiz {
	// data members
	private Integer quizId;
	private Integer quizUserId;// mapped by User - userId
	private Integer quizTotalPoints;
	private Integer quizObtPoints;
	private Integer quizSubjectId;
	private Integer quizScoreCard;// mapped by ScoreCard - scoreCardId
	
	// Default constructor
	public Quiz() {
	}

	// parameterized constructor
	public Quiz(Integer quizId, Integer quizUserId, Integer quizTotalPoints, Integer quizObtPoints,
			Integer quizSubjectId, Integer quizScoreCard) {
		this.quizId = quizId;
		this.quizUserId = quizUserId;
		this.quizTotalPoints = quizTotalPoints;
		this.quizObtPoints = quizObtPoints;
		this.quizSubjectId = quizSubjectId;
		this.quizScoreCard = quizScoreCard;
	}

	// setter getter method
	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public Integer getQuizUserId() {
		return quizUserId;
	}

	public void setQuizUserId(Integer quizUserId) {
		this.quizUserId = quizUserId;
	}

	public Integer getQuizTotalPoints() {
		return quizTotalPoints;
	}

	public void setQuizTotalPoints(Integer quizTotalPoints) {
		this.quizTotalPoints = quizTotalPoints;
	}

	public Integer getQuizObtPoints() {
		return quizObtPoints;
	}

	public void setQuizObtPoints(Integer quizObtPoints) {
		this.quizObtPoints = quizObtPoints;
	}


	public Integer getQuizSubjectId() {
		return quizSubjectId;
	}

	public void setQuizSubjectId(Integer quizSubjectId) {
		this.quizSubjectId = quizSubjectId;
	}

	public Integer getQuizScoreCard() {
		return quizScoreCard;
	}

	public void setQuizScoreCard(Integer quizScoreCard) {
		this.quizScoreCard = quizScoreCard;
	}

	
	// toString method
	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizUserId=" + quizUserId + ", quizTotalPoints=" + quizTotalPoints
				+ ", quizObtPoints=" + quizObtPoints + ", quizSubjectId=" + quizSubjectId + ", quizScoreCard="
				+ quizScoreCard + "]";
	}
}
