package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Ers_Reimbursment_Type;
import com.revature.utils.ConnectionUtil;

public class ErsReimbursmentTypeDao  implements Ers_Reimbursment_Type_Interface{

	@Override
	public String getReimbursmentTypeById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ERS_REIMBURSMENT_TYPE WHERE REIMB_TYPE_ID = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(id)); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();
			return rs.getString("REIM_TYPE");
			
			}catch (SQLException e) {
			System.out.println("Couldn't get type by id");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Ers_Reimbursment_Type> getAllReimbursmentTypes() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ERS_REIMBURSMENT_TYPE ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setString(1, String.valueOf(id)); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();
			
			List<Ers_Reimbursment_Type> x = null ;
			while(rs.next()) {
				
				Ers_Reimbursment_Type temp = new Ers_Reimbursment_Type(
						rs.getInt("REIM_TYPE_ID"),
						rs.getString("REIM_TYPE")
						);
				x.add(temp);
			}
			return x;
			}catch (SQLException e) {
			System.out.println("Couldn't get all types");
			e.printStackTrace();
		}
		return null;
	}

}
