package com.quiztaker.main.serviceI;

import java.util.LinkedHashMap;

import com.quiztaker.main.entity.Subject;

public interface SubjectServiceI {
	// abstract method to add subject and returns added subject
	public Subject addSubject(Subject subjectToAdd);
	
	// abstract method to get all subjects with keys
	LinkedHashMap<Integer, Subject> getSubjectsWithKeys();
}
