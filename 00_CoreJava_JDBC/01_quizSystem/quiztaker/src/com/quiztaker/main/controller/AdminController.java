package com.quiztaker.main.controller;

import com.quiztaker.main.exception.CredentialsMismatchedException;
import com.quiztaker.main.serviceImpl.AdminServiceImpl;

public class AdminController {
	// Object for AdminServiceImpl
	AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
	
	// authAdmin request
	public Boolean authAdmin(String adminUsername , String adminPassword){
		Boolean isAdminAuthenticated = false;
	
		try {
			// calling authAdmin of AdminServiceImpl
			isAdminAuthenticated = this.adminServiceImpl.authAdmin(adminUsername, adminPassword);
			
			return isAdminAuthenticated;
			
		} catch (CredentialsMismatchedException e) {
			System.err.println("\nCredentialsMismatchedException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("\nException : " + e.getMessage());
		}
		
		// if not authenticated
		return isAdminAuthenticated;
	}
}
