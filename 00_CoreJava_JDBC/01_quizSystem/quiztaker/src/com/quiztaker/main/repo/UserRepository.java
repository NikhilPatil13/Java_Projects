package com.quiztaker.main.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.quiztaker.main.entity.User;
import com.quiztaker.main.helper.CreateConnection;

// table name = tbl_user
public class UserRepository {
	// getting connection 
	Connection conn = CreateConnection.getConnection();
	
	// method to get user having provided emailId and returns found user
	public User findByUserEmailId(String emailId){
		// creating object for User to return 
		User foundUser = new User();
		
		try {
			// string sql query
			String query = "SELECT * FROM tbl_user having useremailid=?";
			
			// prepare query
			PreparedStatement ps = conn.prepareStatement(query);
			
			// setting ps parameters
			ps.setString(1,emailId);
			
			// executing ps
			ResultSet rs = ps.executeQuery();
		
			// traversing rs and setting values in foundUser
			while(rs.next()) {
				foundUser.setUserId(rs.getInt("userid"));
				foundUser.setUserFName(rs.getString("userfname"));
				foundUser.setUserLName(rs.getString("userlname"));
				foundUser.setUserEmailId(rs.getString("useremailid"));
				foundUser.setUserContactNo(rs.getString("usercontactno"));
				foundUser.setUserAddress(rs.getString("useraddress"));
				foundUser.setUserPassword(rs.getString("userpassword"));
			}
			
			// checking and returning in case of email id not found
			if(foundUser.getUserEmailId()==null) {
				return null;
			}
			
			
		}catch(Exception e) {
			System.err.println("(User) findByUserEmailId : "+e.getMessage());
		}
		
		// returning foundUser
		return foundUser;
	}
	
	// method to find user by provided contact no and returns user
	public User findByUserContactNo(String contactNo){
		// taking object of user to return
		User foundUser = new User();
		try {
			// string sql query 
			String query = "SELECT * FROM tbl_user WHERE usercontactno=?";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
		
			// setting ps parameters
			ps.setString(1, contactNo);
			
			// executing ps
			ResultSet rs = ps.executeQuery();
		
			// traversing rs and setting values in foundUser
			while(rs.next()) {
				foundUser.setUserId(rs.getInt("userid"));
				foundUser.setUserFName(rs.getString("userfname"));
				foundUser.setUserLName(rs.getString("userlname"));
				foundUser.setUserEmailId(rs.getString("useremailid"));
				foundUser.setUserContactNo(rs.getString("usercontactno"));
				foundUser.setUserAddress(rs.getString("useraddress"));
				foundUser.setUserPassword(rs.getString("userpassword"));
			}
			
			// checking and returning in case of contact no not found
			if(foundUser.getUserContactNo()==null) {
				return null;
			}
			
		}catch(Exception e) {
			System.err.println("(User) findByUserContactNo : "+e.getMessage());
		}
		
		// returing foundUser
		return foundUser;
	}

	// method to save new user and returns saved user
	public User save(User userToAdd){
		// taking variable to return result
		int isUserAdded = 0;
		
		try {
			// string sql query
			String query = "INSERT INTO tbl_user(userfname,userlname,useremailid,usercontactno,useraddress,userpassword) VALUES (?,?,?,?,?,?)";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
			
			// setting parameters in ps
			ps.setString(1, userToAdd.getUserFName());
			ps.setString(2, userToAdd.getUserLName());
			ps.setString(3, userToAdd.getUserEmailId());
			ps.setString(4, userToAdd.getUserContactNo());
			ps.setString(5, userToAdd.getUserAddress());
			ps.setString(6, userToAdd.getUserPassword());
			
			// executing ps
			isUserAdded = ps.executeUpdate();
			
			if(isUserAdded==1) {
				return userToAdd;
			}
			
			
		}catch(Exception e) {
			System.err.println("(User) save : "+e.getMessage());
		}
		
		return null;
		
	}
	
}
