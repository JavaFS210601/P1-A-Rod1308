package com.revature.models;

public class Ers_User {

	public int ers_user_id;
	public String ers_username;
	public String ers_password;
	public String user_first_name;
	public String user_last_name;
	public String user_email;
	public int user_rolde_id;
	
	
	public Ers_User(int ers_user_id, String ers_username, String ers_password, String user_first_name,
			String user_last_name, String user_email, int user_rolde_id) {
		super();
		this.ers_user_id = ers_user_id;
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_rolde_id = user_rolde_id;
	}


	public int getErs_user_id() {
		return ers_user_id;
	}
	public void setErs_user_id(int ers_user_id) {
		this.ers_user_id = ers_user_id;
	}


	public String getErs_username() {
		return ers_username;
	}
	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}


	public String getErs_password() {
		return ers_password;
	}
	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}


	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}


	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}


	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public int getUser_rolde_id() {
		return user_rolde_id;
	}
	public void setUser_rolde_id(int user_rolde_id) {
		this.user_rolde_id = user_rolde_id;
	}


	@Override
	public String toString() {
		return "Ers_Users [ers_user_id=" + ers_user_id + ", ers_username=" + ers_username + ", ers_password="
				+ ers_password + ", user_first_name=" + user_first_name + ", user_last_name=" + user_last_name
				+ ", user_email=" + user_email + ", user_rolde_id=" + user_rolde_id + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
