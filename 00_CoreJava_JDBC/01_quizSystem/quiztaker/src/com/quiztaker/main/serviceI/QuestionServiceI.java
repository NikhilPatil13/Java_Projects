package com.quiztaker.main.serviceI;

import java.util.LinkedHashMap;
import java.util.List;

import com.quiztaker.main.entity.Option;
import com.quiztaker.main.entity.Question;

public interface QuestionServiceI {
	// abstract method to add question and list of options and returns added question
	public Question addQuestionWithOptions(String subjectName, Question question ,List<Option> listOfOptions);

	// abstract method to get all questions with its options and other details and returns map of question and list of options
	public LinkedHashMap<Question, List<Option>> getAllQuestionsWithOptions();
}
