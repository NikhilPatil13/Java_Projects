package com.quiztaker.main.controller;

import java.util.LinkedHashMap;

import com.quiztaker.main.entity.Subject;
import com.quiztaker.main.exception.EntityNotFoundException;
import com.quiztaker.main.exception.EntityNotSavedException;
import com.quiztaker.main.serviceImpl.SubjectServiceImpl;

public class SubjectController {
	// object for SubjectServiceImpl
	private SubjectServiceImpl subjectServiceImpl = new SubjectServiceImpl();
	
	
	// addSubject request
	public String addSubject(Subject subToAdd){
		try {
			// calling addSubject method of SubjectServiceImpl
			Subject savedSubject = this.subjectServiceImpl.addSubject(subToAdd);
		
			return "Subject Saved.";
		}catch(EntityNotSavedException e) {
			System.err.println("\nEntityNotSavedException : "+e.getMessage());
		}catch(Exception e) {
			System.err.println("\nException : "+e.getMessage());
		}
		
		// if not saved
		return "Subject Not Saved.";
		
	}
	
	// getSubjectsWithKeys request
	public LinkedHashMap<Integer,Subject> getSubjectsWithKeys(){
		// to return
		LinkedHashMap<Integer,Subject> subjectsWithKeys = new LinkedHashMap<>();
		
		try {
			// calling getSubjectWithKeys method of SubjectServiceImpl
			subjectsWithKeys = this.subjectServiceImpl.getSubjectsWithKeys();
			
			return subjectsWithKeys;
			
		}catch(EntityNotFoundException e) {
			System.err.println("\nEntityNotFoundException : "+e.getMessage());
		}catch(Exception e) {
			System.err.println("\nException : "+e.getMessage());
		}
		
		// not found , return empty
		return subjectsWithKeys;
	}
}
