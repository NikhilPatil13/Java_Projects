package com.quiztaker.main.serviceI;

import com.quiztaker.main.entity.Subject;
import com.quiztaker.main.entity.User;

public interface QuizServiceI {
	// abstract method to take quiz by provided user and for provided subject
	public void takeQuiz(User user, Subject subjectForQuiz);
}
