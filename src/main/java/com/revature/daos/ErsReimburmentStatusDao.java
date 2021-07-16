package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Ers_Reimbursment_Status;
import com.revature.utils.ConnectionUtil;

public class ErsReimburmentStatusDao implements Ers_Reimbursment_Status_Interface  {


	@Override
	public String getReimbursmentStatusById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ERS_REIMBURSMENT_STATUS WHERE REIMB_STATUS_ID = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(id)); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();
			return rs.getString("REIM_STATUS");
			
			}catch (SQLException e) {
			System.out.println("Couldn't get home by name");
			e.printStackTrace();
		}
		return null;
	}

}
