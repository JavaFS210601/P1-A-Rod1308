package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Ers_User;

public interface Ers_User_Interface {
	
	public ArrayList<Ers_User> getUsers();
	
	public void createUser(Ers_User x);

}
