// User entity class
package com.quiztaker.main.entity;

public class User {
	// data members
	private Integer userId;
	private String userFName;
	private String userLName;
	private String userEmailId;
	private String userContactNo;
	private String userAddress;
	private String userPassword;

	
	// default constructor
	public User() {
	}

	// parameterized constructor
	public User(Integer userId, String userFName, String userLName, String userEmailId, String userContactNo,
			String userAddress, String userPassword) {
		this.userId = userId;
		this.userFName = userFName;
		this.userLName = userLName;
		this.userEmailId = userEmailId;
		this.userContactNo = userContactNo;
		this.userAddress = userAddress;
		this.userPassword = userPassword;
	}



	// setter getter methods
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserContactNo() {
		return userContactNo;
	}

	public void setUserContactNo(String userContactNo) {
		this.userContactNo = userContactNo;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	// toString method
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFName=" + userFName + ", userLName=" + userLName + ", userEmailId="
				+ userEmailId + ", userContactNo=" + userContactNo + ", userAddress=" + userAddress + ", userPassword="
				+ userPassword + "]";
	}
}
