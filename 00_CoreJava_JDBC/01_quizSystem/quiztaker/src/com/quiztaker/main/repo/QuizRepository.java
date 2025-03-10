package com.quiztaker.main.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	// method to count total quiz given by a user having provided user id and returns count
	public Integer findCountByUserId(Integer userId){
		// taking variable to return 
		int totalQuizByUser = 0;
		
		try {
			// string sql query
			String query = "SELECT COUNT(quizid) FROM tbl_quiz WHERE quizuserid=?";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
	
			// setting parameters in ps
			ps.setInt(1, userId);
			
			// execute ps
			ResultSet rs = ps.executeQuery();
		
			// traversing rs
			while(rs.next()) {
				totalQuizByUser = rs.getInt(1);
			}
		}catch(Exception e) {
			System.err.println(" (Quiz)findCountByUserId : "+e.getMessage());
		}
		
		// returning totalQuizByUser
		return totalQuizByUser;
	}

	// method to get all quizes and returns list of quizes
	public List<Quiz> findAll() {
		// taking list to return
		List<Quiz> allQuizes = new ArrayList<>();
		
		try {
			// string sql query
			String query = "SELECT * FROM tbl_quiz";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
			
			// executing ps
			ResultSet rs = ps.executeQuery();
			
			// traversing rs
			while(rs.next()) {
				// creating Quiz object to return 
				Quiz quiz = new Quiz();
				
				// setting parameters in quiz
				quiz.setQuizId(rs.getInt("quizid"));
				quiz.setQuizUserId(rs.getInt("quizuserid"));
				quiz.setQuizSubjectId(rs.getInt("quizsubid"));
				quiz.setQuizObtPoints(rs.getInt("quizobtpoints"));
				quiz.setQuizTotalPoints(rs.getInt("quiztotalpoints"));
				
				// add current quiz in allQuizes list
				allQuizes.add(quiz);
			}
		}catch(Exception e) {
			System.err.println(" (Quiz)findAll : "+e.getMessage());
		}
			
		// returing list
		return allQuizes;
		
	}

	// method to do sum of total marks and obtained marks of a user having provided userid and returns a list containing obtained points and total points
	public List<Integer> findSumOfTotalAndObtPoints(Integer userId) {
		// taking a list to return
		List<Integer> obtAndTotalPoints = new ArrayList<>();
		
		try {
			// string sql query
			String query = "SELECT SUM(quizobtpoints),SUM(quiztotalpoints) FROM tbl_quiz WHERE quizuserid=?";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
		
			// setting parameters in ps
			ps.setInt(1, userId);
			
			// executing ps
			ResultSet rs = ps.executeQuery();
		
			// traversing rs 
			while(rs.next()){
				obtAndTotalPoints.add(rs.getInt(1));
				obtAndTotalPoints.add(rs.getInt(2));
			}
			
		}catch(Exception e) {
			System.err.println(" (Quiz)findSumOfTotalAndObtPoints : "+e.getMessage());
		}
		
		
		// returning obtAndTotalPoints
		return obtAndTotalPoints;
			
		
	}

}
