package com.quiztaker.main.controller;

import java.util.LinkedHashMap;
import java.util.List;

import com.quiztaker.main.entity.Option;
import com.quiztaker.main.entity.Question;
import com.quiztaker.main.exception.EntityAlredyPresentException;
import com.quiztaker.main.exception.EntityNotFoundException;
import com.quiztaker.main.exception.EntityNotSavedException;
import com.quiztaker.main.serviceImpl.QuestionServiceImpl;

public class QuestionController {
	
	// object for QuestionServiceImpl
	QuestionServiceImpl questionServiceImpl = new QuestionServiceImpl();
	
	// addQuestionWithOptions request and returns a message
	public String addQuestionWithOptions(String subjectName, Question question , List<Option> listOfOptions){

		try {
			// call to addQuestionWithOptions method of QuestionServiceImpl
			Question savedQuestion = this.questionServiceImpl.addQuestionWithOptions(subjectName, question, listOfOptions);

			//System.out.println("Saved Question : "+savedQuestion);
			
			// returning msg
			return "Question Saved.";
			
		}catch(EntityAlredyPresentException e) {
			System.err.println("\nEntityAlreadyPresentException : "+e.getMessage());
		}catch(EntityNotSavedException e) {
			System.err.println("\nEntityNotSavedException : "+e.getMessage());
		}catch(Exception e) {
			System.err.println("\nException : "+e.getMessage());
		}
		
		// if not saved return msg
		return "Question Not Saved.";
	}
	
	// getAllQuestionsWithOptions request and returns -----
	public LinkedHashMap<Question,List<Option>> getAllQuestionsWithOptions(){
		LinkedHashMap<Question,List<Option>> allQuestionsWithOptions = new LinkedHashMap<Question, List<Option>>();
		try {
			// call to getAllQuestionsWithOptions method QuestionServiceImpl
			allQuestionsWithOptions = this.questionServiceImpl.getAllQuestionsWithOptions();
			
			
		}catch(EntityNotFoundException e) {
			System.err.println("\nEntityNotFoundException : "+"Questions Not Found."+e.getMessage());
		}catch(Exception e) {
			System.err.println("\nException : "+e.getMessage());
		}
		
		// checking and returning
		return allQuestionsWithOptions;
		
	}
	
}
