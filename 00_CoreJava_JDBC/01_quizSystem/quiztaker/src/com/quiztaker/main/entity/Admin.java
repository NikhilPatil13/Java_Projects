package com.quiztaker.main.entity;

public class Admin {
	// data members
	private String adminUsername;
	private String adminPassword;

	// getters setters
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	
	// toString method
	@Override
	public String toString(){
		return "Admin Credentials : Username : "+this.adminUsername+"\n Password : "+this.adminPassword;
	}
	
}
