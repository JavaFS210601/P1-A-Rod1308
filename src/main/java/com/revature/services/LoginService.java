package com.revature.services;

public class LoginService {
	
	public boolean login(String username, String password) {
		if(username.equals(null) && password.equals(null)) {
			return true;
		}
		
		return false;
	}

}
