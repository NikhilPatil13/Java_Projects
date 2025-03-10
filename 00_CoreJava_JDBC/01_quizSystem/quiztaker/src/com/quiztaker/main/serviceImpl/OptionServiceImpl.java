package com.quiztaker.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.quiztaker.main.entity.Option;
import com.quiztaker.main.entity.Question;
import com.quiztaker.main.exception.EntityNotFoundException;
import com.quiztaker.main.exception.EntityNotSavedException;
import com.quiztaker.main.repo.OptionRepository;
import com.quiztaker.main.serviceI.OptionServiceI;

public class OptionServiceImpl implements OptionServiceI {

	// object for OptionRepository
	OptionRepository optionRepository = new OptionRepository();

	// blogic for addOptionsForQuestion
	@Override
	public Boolean addOptionsForQuestion(List<Option> optionsList, Question question) {
		// taking boolean variable to return
		Boolean isOptionsSaved = false;

		try {
			// need to save all options present in provided list for provided question
			// call to saveAll() method of OptionRepository
			isOptionsSaved = optionRepository.saveAll(optionsList, question);

			// checking isOptionSavedOrNot
			if (!isOptionsSaved) {
				// options not saved
				throw new EntityNotSavedException("Options Not Saved.");
			}
		} catch (EntityNotSavedException e) {
			System.err.println("\nEntityNotSavedException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("\nException : " + e.getMessage());
		}

		// return isOptionsSaved
		return isOptionsSaved;
	}

	// blogic for findAllOptions
	public List<Option> findAllOptions() {

		// call to findAll method of OptionRepository
		List<Option> allOptions = this.optionRepository.findAll();

		// checking options are present or not
		if (allOptions.isEmpty()) {
			throw new EntityNotFoundException("Options Not Found.");
		}

		return allOptions;

	}
}
