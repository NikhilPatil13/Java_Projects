package com.quiztaker.main.controller;

import com.quiztaker.main.entity.Subject;
import com.quiztaker.main.entity.User;
import com.quiztaker.main.exception.EntityNotFoundException;
import com.quiztaker.main.exception.EntityNotSavedException;
import com.quiztaker.main.serviceImpl.QuizServiceImpl;

public class QuizController {

	// object for QuizServiceImpl
	private QuizServiceImpl quizServiceImpl = new QuizServiceImpl();
	
	// takeQuiz request
	public void takeQuiz(User loggedInUser , Subject subjectForQuiz) {

		try {
			// call to takeQuiz method of QuizServiceImpl
			this.quizServiceImpl.takeQuiz(loggedInUser,subjectForQuiz);
		}
		catch(EntityNotFoundException e) {
			System.err.println("\nEntityNotFoundException : "+e.getMessage());
		}
		catch(EntityNotSavedException e) {
			System.err.println("\nEntityNotSavedException : "+e.getMessage());
		}
		catch(Exception e) {
			System.err.println("\nException : "+e.getMessage()+"\nPlease Try Again...");
		}	
	}
	
	// getCountOfQuizesAccToUser request
	public Integer getCountOfQuizesAccToUser(User user){

		// call to getCountOfTotalQuizesOfUser method of QuizServiceImpl
		return this.quizServiceImpl.getCountOfTotalQuizesOfUser(user);

	}

}
