package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Ers_User;
import com.revature.utils.ConnectionUtil;

public class ErsUserDao implements Ers_User_Interface{

	@Override
	public ArrayList<Ers_User> getUsers() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM public.ERS_USERS;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setString(1, String.valueOf(id)); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Ers_User> UserList = new ArrayList<Ers_User>();
			
			while(rs.next()) { //while there are results left in the ResultSet (rs)
				
				//Create a new Employee Object from each returned record
				//This is the Employee Class's all args constructor
				//And we're filling it with each column of the Employee record
				Ers_User eu = new Ers_User(
						rs.getInt("ERS_USER_ID"),
						rs.getString("ERS_USERNAME"),
						rs.getString("ERS_PASSWORD"),
						rs.getString("USER_FIRST_NAME"),
						rs.getString("USER_LAST_NAME"),
						rs.getString("USER_EMAIL"),
						rs.getInt("USER_ROLE_ID")
						);
				
				UserList.add(eu);
				System.out.println(eu.toString());
					
			}
			return UserList;
		}catch (SQLException e) {
			System.out.println("Couldn't users");
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public void createUser(Ers_User x) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO public.ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID)"
					+ "VALUES (?,?,?,?,?,?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, x.ers_username);
			ps.setString(2, x.ers_password);
			ps.setString(3, x.user_first_name);
			ps.setString(4, x.user_last_name);
			ps.setString(5, x.user_email);
			ps.setInt(6, x.user_rolde_id);
			
			
			ps.executeUpdate();
			
			System.out.println("User: Created");
			System.out.println(x.toString());
			
				
				
		}catch (SQLException e) {
			System.out.println("Couldn't create user");
			e.printStackTrace();
		}
		
		
	}
}
