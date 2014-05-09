package com.easylearnjava.service;

import com.easylearnjava.dao.LoginDao;

public class LoginService {
	
	/**
	 * Method for implementing the business logic, like comparing the passwords
	 */
	public boolean isValidPassword(String userName, String password) {
		
		LoginDao loginDao = new LoginDao();
		
		String pwdFromDB = loginDao.getUserPassword(userName);
		if (null != pwdFromDB) {
			if (pwdFromDB.equals(password)) {
				return true;
			}
		}
		return false;
	}

}
