package com.quiztaker.main.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.quiztaker.main.entity.Admin;
import com.quiztaker.main.helper.CreateConnection;

// table name = tbl_admin
public class AdminRepository {
	// in this class we require connection object
	Connection conn = CreateConnection.getConnection();

	// get admin by provided adminUsername
	public Admin findByAdminUsername(String adminUsername){
		try {
			// creating object for Admin to return -> if admin found returns data else returns null
			Admin foundAdmin = new Admin();
			
			// query to return admin object having username = adminUsername
			// a string sql query
			String query = "SELECT * FROM tbl_admin where adminusername=?";
			
			// prepare query
			PreparedStatement ps =  conn.prepareStatement(query);
			
			// setting parameters in ps
			ps.setString(1, adminUsername);
			
			// execute query
			ResultSet rs = ps.executeQuery();
			
			// checking rs is null or not
			if(!rs.equals(null)) {
				while(rs.next()) {
					foundAdmin.setAdminUsername(rs.getString(1));
					foundAdmin.setAdminPassword(rs.getString(2));
				}
			}
			
			// checking foundAdmin contains username or not
			if(foundAdmin.getAdminUsername()!=null) {
				return foundAdmin;
			}
		}
		catch(Exception e) {
			System.err.println("findByAdminUsername : "+e.getMessage());
		}
		
		// returns null
		return null;
	}
	

}
