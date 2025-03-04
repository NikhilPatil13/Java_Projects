package com.quiztaker.main.controller;

import com.quiztaker.main.exception.EntityNotFoundException;
import com.quiztaker.main.serviceImpl.OptionServiceImpl;

public class OptionController {
	// object for OptionServiceImpl
	private OptionServiceImpl optionServiceImpl = new OptionServiceImpl();

	// findAllOptions request
	public void findAllOptions() {
		try {
			// call to findAllOptions method of OptionServiceImpl
			this.optionServiceImpl.findAllOptions();
		}catch(EntityNotFoundException e) {
			System.err.println("\nEntityNotFoundException : "+e.getMessage());
		}
	}
}
