package com.quiztaker.main.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.quiztaker.main.entity.Subject;
import com.quiztaker.main.helper.CreateConnection;

// table name = tbl_subject
public class SubjectRepository {
	// getting connection by calling getConnection method of CreateConnection class
	Connection conn = CreateConnection.getConnection();
	
	
	// method to add new subject and returns added subject
	public Subject save(Subject subjectToAdd){
		// taking variable to return 
		int isSubSaved = 0;
		
		try {
			// string sql query
			String query = "INSERT INTO tbl_subject(subname) VALUES(?)";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
		
			// setting parameters in ps
			ps.setString(1, subjectToAdd.getSubName());
			
			// executing ps
			isSubSaved = ps.executeUpdate();
			
		}catch(Exception e) {
			System.err.println("(Subject) save : "+e.getMessage());
		}
		
		// returning
		if(isSubSaved==0) {
			return null;
		}
		else {
			return subjectToAdd;
		}
	}
	
	// method to get all subjects
	public List<Subject> findAll(){
		// taking list to return
		List<Subject> subjectList = new ArrayList<>();
	
		try {
			// string sql query
			String query = "SELECT * FROM tbl_subject";

			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
			
			// executing ps
			ResultSet rs = ps.executeQuery();
		
			// traversing rs
			while(rs.next()) {
				Subject subject = new Subject();
				
				subject.setSubId(rs.getInt("subid"));
				subject.setSubName(rs.getString("subname"));
				
				// adding subject in subjectList
				subjectList.add(subject);
			}
		}catch(Exception e) {
			System.err.println("(Subject) findAll : "+e.getMessage());
		}
		
		// returing list
		return subjectList;
	}

	// method to get a subject having provided name and returns found subject
	public Subject findBySubjectName(String subjectName) {
		// taking Subject object to return
		Subject foundSubject = new Subject();
		
		try {
			// string sql query
			String query = "SELECT * FROM tbl_subject WHERE subname=?";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
			
			// setting parameters in ps
			ps.setString(1, subjectName);
			
			// execute ps
			ResultSet rs = ps.executeQuery();
			
			// traversing rs
			while(rs.next()) {
				foundSubject.setSubId(rs.getInt("subid"));
				foundSubject.setSubName(rs.getString("subname"));
			}
			
		}catch(Exception e) {
			System.err.println(" (Subject) findBySubjectName : "+e.getMessage());
		}
		
		// returning foundSubject
		return foundSubject;
		
	}
	
	
}
