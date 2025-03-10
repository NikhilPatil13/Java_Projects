package com.quiztaker.main.controller;

import java.util.LinkedHashMap;

import com.quiztaker.main.entity.Quiz;
import com.quiztaker.main.entity.User;
import com.quiztaker.main.exception.CredentialsMismatchedException;
import com.quiztaker.main.exception.EntityAlredyPresentException;
import com.quiztaker.main.exception.EntityNotFoundException;
import com.quiztaker.main.serviceImpl.UserServiceImpl;

public class UserController {
	// object for UserServiceImpl
	private	UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	// signUpUser request
	public Boolean signUpUser(User userToAdd){
		
		try {
			// calling signUpUser method of UserServiceImpl
			User signedUpUser = this.userServiceImpl.signUpUser(userToAdd);
		
			return true;
			
		} catch (EntityAlredyPresentException e) {
			System.err.println("\nEntityAlredyPresentException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("\nException : " + e.getMessage());
		}
		
		// is not saveed then return false
		return false;
	}

	// authUser request
	public Boolean authUser(String userUsername, String userPassword) {
		Boolean isUserAuthenticated = false;
		try {
			// calling authUser method of UserServiceImpl
			isUserAuthenticated = this.userServiceImpl.authUser(userUsername, userPassword);
			
			
		} catch (CredentialsMismatchedException e) {
			System.err.println("\nCredentialsMismatchedException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("\nException : " + e.getMessage());
		}

		
		// returning
		return isUserAuthenticated;
	}

	//getUserByUsername request
	public User getUserByUsername(String userUsername) {
		// taking object of User to assign and returning value
		User foundUser = new User();
		
		try {
			// calling getUserByUsername method of UserServiceImpl
			foundUser = this.userServiceImpl.getUserByUsername(userUsername);
			
		} catch (EntityNotFoundException e) {
			System.err.println("\nEntityNotFoundException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("\nException : " + e.getMessage());
		}
		
		return foundUser;
	}

	// getAllUsersDetails request
	public void getAllUsersDetails() {
		// calling getAllUserDetails method of UserServiceImpl
		this.userServiceImpl.getAllUserDetails();
	}
}
