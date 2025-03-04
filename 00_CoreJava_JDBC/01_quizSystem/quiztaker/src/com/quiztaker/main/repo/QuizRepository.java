package com.quiztaker.main.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.quiztaker.main.entity.Quiz;
import com.quiztaker.main.helper.CreateConnection;


//table name = tbl_quiz
public class QuizRepository {
	// getting connection 
	private Connection conn = CreateConnection.getConnection();

	// method to save the quiz and return saved quiz
	public Quiz save(Quiz quizToSave) {
		// taking isAdded variable to check quizToSave is saved or not
		int isAdded=0;
		
		try {
			// string sql query
			String query = "INSERT INTO tbl_quiz(quizuserid,quizobtpoints,quiztotalpoints,quizsubid)VALUES(?,?,?,?)";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
		
			// seting parameters in ps
			ps.setInt(1, quizToSave.getQuizUserId());
			ps.setInt(2, quizToSave.getQuizObtPoints());
			ps.setInt(3, quizToSave.getQuizTotalPoints());
			ps.setInt(4, quizToSave.getQuizSubjectId());
			
			// execute ps
			isAdded = ps.executeUpdate();
		}catch(Exception e) {
			System.err.println(" (Quiz)save : "+e.getMessage());
		}
		
		// checking and returning
		if(isAdded!=0) {
			return quizToSave;
		}else {
			return null;
		}
		
	}

}
