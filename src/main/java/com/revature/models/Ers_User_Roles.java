package com.revature.models;

public class Ers_User_Roles {
	
	public int ers_user_role;
	public String user_role;
	
	

	public Ers_User_Roles(int ers_user_role, String user_role) {
		super();
		this.ers_user_role = ers_user_role;
		this.user_role = user_role;
	}


	public int getErs_user_role() {
		return ers_user_role;
	}


	public void setErs_user_role(int ers_user_role) {
		this.ers_user_role = ers_user_role;
	}


	public String getUser_role() {
		return user_role;
	}


	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}


	@Override
	public String toString() {
		return "Ers_User_Roles [ers_user_role=" + ers_user_role + ", user_role=" + user_role + "]";
	}
	
	
	
	
	
}
