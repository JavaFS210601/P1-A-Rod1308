package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.ErsUserDao;
import com.revature.daos.Ers_User_Interface;
import com.revature.models.Ers_User;

public class LoginService {
	Ers_User_Interface userDao = new ErsUserDao();
	
	public boolean login(String username, String password) {
		
		//get credentials from DAO
		ArrayList<Ers_User> userList = new ArrayList<>();
		
		ErsUserDao userDao = new ErsUserDao();
		
		userList = userDao.getUsers();
		
		for(int i = 0; i < userList.size(); i++) {
			if(username.equals(userList.get(i).ers_username) && password.equals(userList.get(i).ers_password)) {
				return true;
			}
			
		}
		
		
		return false;
	}

	public ArrayList<Ers_User> getAllReimbursment() {
		
		return userDao.getUsers();
	}

}
