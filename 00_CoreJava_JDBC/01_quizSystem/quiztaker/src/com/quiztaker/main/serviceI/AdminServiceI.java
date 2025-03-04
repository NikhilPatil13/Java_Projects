package com.quiztaker.main.serviceI;

public interface AdminServiceI {
	// abstract method to authenticate admin by checking provided adminUsername and adminPassword
	public Boolean authAdmin(String adminUsername , String adminPassword);
}
