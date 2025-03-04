package com.quiztaker.main.serviceI;

import java.util.List;

import com.quiztaker.main.entity.Option;
import com.quiztaker.main.entity.Question;

public interface OptionServiceI {

	// abstract method to add list of options for a question and returns boolean(question added or not)
	public Boolean addOptionsForQuestion(List<Option> optionsList , Question question);
}
