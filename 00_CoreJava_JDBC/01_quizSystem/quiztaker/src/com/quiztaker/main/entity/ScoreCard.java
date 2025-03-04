// ScoreCard entity class
package com.quiztaker.main.entity;

public class ScoreCard {
	// data members
	private Integer scoreCardId;
	private Integer scoreCardUserId;// mapped by User - userId
	private Integer scoreCardQuizId;// mapped by Quiz - quizId
	private Integer scoreCardObtPoints;
	private Integer scoreCardTotalPoints;

	// default constructor
	public ScoreCard() {
	}

	// parameterized constructor
	public ScoreCard(Integer scoreCardId, Integer scoreCardUserId, Integer scoreCardQuizId, Integer scoreCardObtPoints,
			Integer scoreCardTotalPoints) {
		this.scoreCardId = scoreCardId;
		this.scoreCardUserId = scoreCardUserId;
		this.scoreCardQuizId = scoreCardQuizId;
		this.scoreCardObtPoints = scoreCardObtPoints;
		this.scoreCardTotalPoints = scoreCardTotalPoints;
	}

	// setter getter methods
	public Integer getScoreCardId() {
		return scoreCardId;
	}

	public void setScoreCardId(Integer scoreCardId) {
		this.scoreCardId = scoreCardId;
	}

	public Integer getScoreCardUserId() {
		return scoreCardUserId;
	}

	public void setScoreCardUserId(Integer scoreCardUserId) {
		this.scoreCardUserId = scoreCardUserId;
	}

	public Integer getScoreCardQuizId() {
		return scoreCardQuizId;
	}

	public void setScoreCardQuizId(Integer scoreCardQuizId) {
		this.scoreCardQuizId = scoreCardQuizId;
	}

	public Integer getScoreCardObtPoints() {
		return scoreCardObtPoints;
	}

	public void setScoreCardObtPoints(Integer scoreCardObtPoints) {
		this.scoreCardObtPoints = scoreCardObtPoints;
	}

	public Integer getScoreCardTotalPoints() {
		return scoreCardTotalPoints;
	}

	public void setScoreCardTotalPoints(Integer scoreCardTotalPoints) {
		this.scoreCardTotalPoints = scoreCardTotalPoints;
	}

	// toString method
	@Override
	public String toString() {
		return "ScoreCard [scoreCardId=" + scoreCardId + ", scoreCardUserId=" + scoreCardUserId + ", scoreCardQuizId="
				+ scoreCardQuizId + ", scoreCardObtPoints=" + scoreCardObtPoints + ", scoreCardTotalPoints="
				+ scoreCardTotalPoints + "]";
	}
}
