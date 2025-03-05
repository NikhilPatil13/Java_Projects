package com.quiztaker.main.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;

import com.quiztaker.main.entity.Quiz;
import com.quiztaker.main.entity.User;
import com.quiztaker.main.exception.CredentialsMismatchedException;
import com.quiztaker.main.exception.EntityAlredyPresentException;
import com.quiztaker.main.exception.EntityNotFoundException;
import com.quiztaker.main.repo.QuizRepository;
import com.quiztaker.main.repo.UserRepository;
import com.quiztaker.main.serviceI.UserServiceI;

public class UserServiceImpl implements UserServiceI {
	// object for UserRepository
	private UserRepository userRepository = new UserRepository();
	
	// object for QuizRepository
	private QuizRepository quizRepository = new QuizRepository();

	// blogic for signUpUser
	@Override
	public User signUpUser(User userToAdd) {
		// taking user object to return
		User savedUser = new User();

		// before saving/adding userToAdd check it's emailid and contactno , if found in
		// db already then throw error else save
		// find user by provided email id , calling findByUserEmailId method of
		// UserRepository
		User foundUserByEmailId = this.userRepository.findByUserEmailId(userToAdd.getUserEmailId());

		// find user by provided contact no, calling findByUserContactNo method of
		// UserRepository
		User foundUserByContactNo = this.userRepository.findByUserContactNo(userToAdd.getUserContactNo());

		// checking and doing further operations
		// if foundUserByEmailId and foundUserByContactNo is null then save userToAdd,
		// if foundUserByEmailId or/and foundUserByContactNo are not null then throw
		// exception
		// for exception
		if (foundUserByEmailId != null) {
			throw new EntityAlredyPresentException("User With Provided Email Id Is Already Present.");
		} else if (foundUserByContactNo != null) {
			throw new EntityAlredyPresentException("User With Provided Contact No. Is Already Present.");
		} else {
			// save userToAdd
			// calling save method of UserRepository to save user
			savedUser = this.userRepository.save(userToAdd);
		}

		return savedUser;
	}

	// blogic for authUser
	@Override
	public Boolean authUser(String userUsername, String userPassword) {
		// taking variable to return
		Boolean isUserAuthenticated = false;

		// for authenticate user, we need to find user by username ie. here username is
		// useremailid , so find user having provided useremailid
		// calling findByUserEmailId method of UserRepository
		User foundUser = this.userRepository.findByUserEmailId(userUsername);

		// checking
		if (foundUser == null) {
			// if not found
			throw new CredentialsMismatchedException("User With Provided EmailId Not Found.");
		} else if (!foundUser.getUserPassword().equals(userPassword)) {
			// foundUser's password is not same as provided password
			throw new CredentialsMismatchedException("Wrong Password.");
		} else {
			// all good then do login/authenticate
			isUserAuthenticated = true;
		}

		// return isUserAuthenticated
		return isUserAuthenticated;
	}

	// blogic for getUserByUsername
	@Override
	public User getUserByUsername(String username) {
		// getting user having provided username
		User foundUser = this.userRepository.findByUserEmailId(username);

		// checking foundUser is null or not
		if (foundUser == null) {
			// no user found
			throw new EntityNotFoundException("User With Provided EmailId Not Found.");
		}

		return foundUser;
	}

	// blogic for getAllUserDetails 
	public void getAllUserDetails() {
		// getting all users list , calling findAll method of UserRepository
		List<User> allUsers = this.userRepository.findAll();
		
		// checking size of allUsers list
		if(allUsers.size()==0) {
			// no users found
			throw new EntityNotFoundException("Users Not Found.");
		}else {
			int srNo = 1;
			// traversing allUsers
			for(User user:allUsers) {
				
				// now getting details of all quizes current user taken
				Integer totalUserQuizesCount = this.quizRepository.findCountByUserId(user.getUserId());
				List<Integer> obtAndTotalPoints = this.quizRepository.findSumOfTotalAndObtPoints(user.getUserId());
				System.out.println(srNo+++"]");
				System.out.println(" Name           : " + user.getUserFName() + " " + user.getUserLName());
				System.out.println(" Email ID       : " + user.getUserEmailId());
				System.out.println(" Contact No     : " + user.getUserContactNo());
				System.out.println(" Address        : " + user.getUserAddress());
				System.out.println(" Total Quizzes  : " + totalUserQuizesCount);
				System.out.println(" Marks Obtained : " + obtAndTotalPoints.get(0) + " / " + obtAndTotalPoints.get(1));
				
				System.out.println("\n-----------------------------");
			}
		}
		
		

		
		
		
	}

}
