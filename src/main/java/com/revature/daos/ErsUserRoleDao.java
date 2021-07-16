package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class ErsUserRoleDao implements Ers_User_Roles_Interface{

	@Override
	public String getUserRoleById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE ERS_USER_ROLE_ID = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(id)); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();
			return rs.getString("USER_ROLE");
			
			}catch (SQLException e) {
			System.out.println("Couldn't get home by name");
			e.printStackTrace();
		}
		return null;
	}

}
