package com.quiztaker.main.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import com.quiztaker.main.entity.Question;
import com.quiztaker.main.entity.Subject;
import com.quiztaker.main.helper.CreateConnection;

// table name = tbl_question
public class QuestionRepository {
	// get connection 
	Connection conn = CreateConnection.getConnection();

	// method to find a question by provided question statement
	public Question findByQuestionStatement(String questionStatement){
		// creating Question object which returns found question
		Question foundQuestion = new Question();
		
		try {
			// string query to find a question having provided questionStatement
			String query = "SELECT * FROM tbl_question WHERE questatement=?";
			
			// prepare query
			PreparedStatement ps = conn.prepareStatement(query);
			
			// setting parameters in ps
			ps.setString(1, questionStatement);

			// execute statement
			ResultSet rs = ps.executeQuery();
		
			// calculate size of rs
			int size=0;
			if(rs.next()) {
				size++;
			}
			
			// now if size==1 then and only then set foundQuestion values
			if(size==1) {
				// setting values of question in rs to foundQuestion
				foundQuestion.setQueId(rs.getInt("queid"));
				foundQuestion.setQueStatement(rs.getString("questatement"));
				foundQuestion.setQuePoints(rs.getInt("quepoints"));
				foundQuestion.setQueSubjectId(rs.getInt("quesubid"));
			}
			else {
				foundQuestion=null;
			}

			
			
		}catch(Exception e) {
			System.err.println("findByQuestionStatement : "+e.getMessage());
		}
		
		// returning foundQuetion
		return foundQuestion;
		
	}
	
	// method to save Question and returns saved question
	public Question save(Question question){
		// creating object for Question to return savedQuestion
		Question savedQuestion = new Question();
		
		try {
			// string query to save question
			String query = "INSERT INTO tbl_question(questatement,quepoints,quesubid) VALUES(?,?,?)";
			
			// prepare query
			PreparedStatement ps = conn.prepareStatement(query);
			
			// setting parameters in query
			ps.setString(1,question.getQueStatement());
			ps.setInt(2, question.getQuePoints());
			ps.setInt(3, question.getQueSubjectId());
			
			// execute ps
			int isQuestionAdded = ps.executeUpdate();
			
			// checking is Question added/saved or not
			if(isQuestionAdded==1) {
				savedQuestion = question;	
			}
			
			
		}catch(Exception e) {
			System.err.println("(Question)save : "+e.getMessage());
		}
		
		// returns savedQuestion
		return savedQuestion;
	}
	
	// method to find question by provided question id and subject id
	public Question findByIdAndSubId(Integer queId , Integer subId){
		// taking object for Question
		Question foundQuestion = new Question();
		
		try {
			
			// string sql query
			String query = "SELECT * FROM tbl_question WHERE queid=? AND quesubid=?";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
		
			// setting parameters in ps
			ps.setInt(1, queId);
			ps.setInt(2, subId);
			
			// executing ps
			ResultSet rs = ps.executeQuery();
		
			// traversing rs
			while(rs.next()) {
				foundQuestion.setQueId(rs.getInt("queid"));
				foundQuestion.setQueStatement(rs.getString("questatement"));
				foundQuestion.setQuePoints(rs.getInt("quepoints"));
				foundQuestion.setQueSubjectId(rs.getInt("quesubid"));
			}
			
		}catch(Exception e) {
			System.err.println("(Question)findById : "+e.getMessage());
		}
		
		// returning foundQuestion
		return foundQuestion;
	}

	// method to find min and max question id for provided subject and returns min and max question id in map
	public Map<Integer,Integer> findMinMaxQueIdForSubject(Subject subjectSelected) {
		// map to return key as min queid and value as max queid
		Map<Integer,Integer> minMaxQueIdforSubject = new HashMap<>();
		
		try {
			// string sql query
			String query = "SELECT MIN(queid),MAX(queId) FROM tbl_question WHERE quesubid=?";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
			
			// setting ps parameter
			ps.setInt(1, subjectSelected.getSubId());
			
			// execute ps
			ResultSet rs = ps.executeQuery();
		
			// traversing rs
			while(rs.next()) {
				// setting current rs value in minQueId
				minMaxQueIdforSubject.put(rs.getInt(1), rs.getInt(2));
			}
			
		}catch(Exception e) {
			System.err.println(" (Qusetion)findMinMaxQueIdForSubject : "+e.getMessage());
		}
		
		// return minMaxQueId
		return minMaxQueIdforSubject;
	}
	
	
	// method to get count of available questions for selected subject and returns count
	public int countForQuestionsOfSubject(Subject subjectForQuiz) {
		// variable to return
		int queCountForSubject=0;
	
		try {
			// string query 
			String query = "SELECT COUNT(queid) FROM tbl_question WHERE quesubid=?";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
		
			// setting parameters in ps
			ps.setInt(1, subjectForQuiz.getSubId());
			
			// executing ps
			ResultSet rs = ps.executeQuery();
		
			// traversing rs
			while(rs.next()) {
				queCountForSubject = rs.getInt(1);
			}
		}catch(Exception e) {
			System.err.println(" (Question)countForQuestionsOfSubject : "+e.getMessage());
		}
		
		// returning count
		return queCountForSubject;
	}
	
	// method to return question having provided id and returns found question
	public Question findById(Integer queId){
		// taking question to return 
		Question foundQuestion = new Question();
		
		try {
			// string sql query
			String query = "SELECT * FROM tbl_question WHERE queid=?";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
		
			// setting parameters in ps
			ps.setInt(1, queId);
			
			// executing ps
			ResultSet rs = ps.executeQuery();
		
			// traversing rs
			while(rs.next()) {
				// setting foundQuestion members
				foundQuestion.setQueId(rs.getInt("queid"));
				foundQuestion.setQueStatement(rs.getString("questatement"));
				foundQuestion.setQuePoints(rs.getInt("quepoints"));
				foundQuestion.setQueSubjectId(rs.getInt("quesubid"));
				
			}
		}catch(Exception e) {
			System.err.println(" (Question) findById : "+e.getMessage());
		}
		
		// returning foundQuestion
		return foundQuestion;
	}
	
}
