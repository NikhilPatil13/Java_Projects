package com.quiztaker.main.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
	// data member
	public static Connection conn = null;

	// static method to get connection
	public static Connection getConnection() {
		try {

			// 1. load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. establish the connection
			CreateConnection.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiztaker","root","root");
		}
		catch(Exception e) {
			System.err.println("Exception In getConnection : "+e.getMessage());
		}
		
		// return conn
		return CreateConnection.conn;
	}
}
