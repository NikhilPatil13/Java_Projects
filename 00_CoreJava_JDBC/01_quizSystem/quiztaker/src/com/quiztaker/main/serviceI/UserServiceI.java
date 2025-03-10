package com.quiztaker.main.serviceI;

import java.util.LinkedHashMap;

import com.quiztaker.main.entity.Quiz;
import com.quiztaker.main.entity.User;

public interface UserServiceI {

	// abstract method to add/signup new user in db and returns added user
	public User signUpUser(User userToAdd);
	
	// abstract method to authenticate user according to provided useremail id and userpassword
	public Boolean authUser(String userUsername , String userPassword);
	
	// abstract method to get user having provided username and returns User
	public User getUserByUsername(String username);
	
	// abstract method to return all users with their quiz details and prints
	public void getAllUserDetails();
	
}
