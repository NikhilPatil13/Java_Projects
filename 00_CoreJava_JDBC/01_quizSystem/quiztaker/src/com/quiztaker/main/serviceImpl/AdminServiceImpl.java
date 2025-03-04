package com.quiztaker.main.serviceImpl;

import com.quiztaker.main.entity.Admin;
import com.quiztaker.main.exception.CredentialsMismatchedException;
import com.quiztaker.main.repo.AdminRepository;
import com.quiztaker.main.serviceI.AdminServiceI;

public class AdminServiceImpl implements AdminServiceI {
	// object of AdminRepository
	AdminRepository adminRepository = new AdminRepository();

	// blogic for authAdmin
	@Override
	public Boolean authAdmin(String adminUsername, String adminPassword) {
		// boolean value to return
		Boolean isAdminValidated = false;

		// check adminusername present in db or not -> in tbl_admin
		// calling findByAdminUsername of AdminRepository
		Admin foundAdmin = this.adminRepository.findByAdminUsername(adminUsername);

		// System.out.println("foundAdmin : "+foundAdmin);
		// checking and doing operation
		if (foundAdmin == null) {
			// no admin found . return exception
			throw new CredentialsMismatchedException("Admin Not Found With Provided Username.");
		} else if (!foundAdmin.getAdminPassword().equals(adminPassword)) {
			// password not matched , throw exception
			throw new CredentialsMismatchedException("Wrong Password.");
		} else {
			// admin present with provided adminUsername
			isAdminValidated = true;
		}
		
		return isAdminValidated;

	}

}
