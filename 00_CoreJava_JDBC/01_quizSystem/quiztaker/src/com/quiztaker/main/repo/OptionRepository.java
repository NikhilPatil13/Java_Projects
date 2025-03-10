package com.quiztaker.main.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.quiztaker.main.entity.Option;
import com.quiztaker.main.entity.Question;
import com.quiztaker.main.helper.CreateConnection;

// table name = tbl_option
public class OptionRepository {
	// getting connection
	Connection conn = CreateConnection.getConnection();
	
	// method to save all options for a question
	public Boolean saveAll(List<Option> optionsList , Question question){
		// taking variable to check saving status
		int status=0;
		
		try {
			
			// string query to insert option in db
			String query = "INSERT INTO tbl_option(optstatement,isoptcorrect,optqueid) VALUES (?,?,?)";
			
			// need to perform query for all options in list
			for(Option option:optionsList) {
				// prepare query
				PreparedStatement ps = conn.prepareStatement(query);
				
				// setting parameters in ps
				ps.setString(1, option.getOptStatement());
				ps.setBoolean(2, option.getIsOptCorrect());
				ps.setInt(3, question.getQueId());
				
				// execute ps
				status = ps.executeUpdate();
				
			}
			
			
		}catch(Exception e) {
			System.err.println("(Option) saveAll : "+e.getMessage());
		}
		
		// checking status and returning
		if(status==1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	// method to find/get all options
	public List<Option> findAll(){
		try {
			// string sql query
			String query = "SELECT * FROM tbl_option";
			
			// prepare query
			PreparedStatement ps = conn.prepareStatement(query);
		
			// execute ps
			ResultSet rs = ps.executeQuery();
			
			// creating a list to store all options
			List<Option> allOptionsList = new ArrayList<Option>();
			
			// traversing rs
			while(rs.next()) {
				// creating a temp Option to set current rs value
				Option option = new Option();
				
				option.setOptId(rs.getInt("optid"));
				option.setOptStatement(rs.getString("optstatement"));
				option.setIsOptCorrect(rs.getBoolean("isoptcorrect"));
				option.setOptQueId(rs.getInt("optqueid"));
			
				// add current option to allOptionsList
				allOptionsList.add(option);
			}
			
			return allOptionsList;
		}catch(Exception e) {
			System.err.println("(Option) findAll : "+e.getMessage());
		}
		
		return null;
	}


	// getting map of options for a question having provided que id 
	public Map<Character,Option> findOptionsByQueId(Integer queId) {
		// taking map to return 
		Map<Character,Option> optionsMap = new LinkedHashMap<>();
		
		try {
			// string sql query
			String query = "SELECT * FROM tbl_option WHERE optqueid=?";
			
			// preparing query
			PreparedStatement ps = conn.prepareStatement(query);
		
			// setting ps parameter
			ps.setInt(1, queId);
			
			// execute ps
			ResultSet rs = ps.executeQuery();
			
			Character key='a';
			// traversing rs
			while(rs.next()) {
				// option object
				Option option = new Option();

				// setting values in option
				option.setOptId(rs.getInt("optid"));
				option.setOptStatement(rs.getString("optstatement"));
				option.setIsOptCorrect(rs.getBoolean("isoptcorrect"));
				option.setOptQueId(rs.getInt("optqueid"));
				
				// add option in optionsMap
				optionsMap.put(key++, option);
				
			}
		}catch(Exception e) {
			System.err.println(" (Option)findOptionsByQueId : "+e.getMessage());
		}
		
		// return map of options
		return optionsMap;
		
	}
}
