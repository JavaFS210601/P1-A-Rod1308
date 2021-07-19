package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Ers_Reimbursment;
import com.revature.models.Ers_User;
import com.revature.utils.ConnectionUtil;

public class ErsReimbursmentDao implements Ers_Reimbursment_Interface {

	@Override
	public Ers_Reimbursment getReimbursmentById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM public.ERS_REIMBURSMENT WHERE REIMB_ID = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(id)); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();

			return new Ers_Reimbursment(
					rs.getInt("REIMB_ID"),
					rs.getInt("REIMB_AMOUNT"),
					rs.getString("REIMB_SUBMITED"),
					rs.getString("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"),
					rs.getString("REIMB_RECIEPT"),
					rs.getInt("REIMB_AUTHOR"),
					rs.getInt("REIMB_RESOLVER"),
					rs.getInt("REIMB_STATUS_ID"),
					rs.getInt("REIMB_TYPE_ID")
					);
			
			}catch (SQLException e) {
			System.out.println("Couldn't get home by name");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Ers_Reimbursment> getReimbursmentByStatus(int status) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM public.ers_reimbursement WHERE REIMB_STATUS_ID = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, String.valueOf(status));
			ps.setInt(1, status);
			
			//maybe change to string
			//ps.setInt(1,userId); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();


			ArrayList<Ers_Reimbursment> ReimbursmentList = new ArrayList<Ers_Reimbursment>();
			
			while(rs.next()) { //while there are results left in the ResultSet (rs)
				
				//Create a new Employee Object from each returned record
				//This is the Employee Class's all args constructor
				//And we're filling it with each column of the Employee record
				Ers_Reimbursment er =  new Ers_Reimbursment(
								rs.getInt("REIMB_ID"),
								rs.getInt("REIMB_AMOUNT"),
								rs.getString("REIMB_SUBMITED"),
								rs.getString("REIMB_RESOLVED"),
								rs.getString("REIMB_DESCRIPTION"),
								rs.getString("REIMB_RECEIPT"),
								rs.getInt("REIMB_AUTHOR"),
								rs.getInt("REIMB_RESOLVER"),
								rs.getInt("REIMB_STATUS_ID"),
								rs.getInt("REIMB_TYPE_ID")
								);
				
				ReimbursmentList.add(er);
				System.out.println(er.toString());
			}
			return ReimbursmentList;
			}catch (SQLException e) {
				System.out.println("Couldn't all reimbursments");
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public ArrayList<Ers_Reimbursment> getReimbursmentByType(int type) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ERS_REIMBURSMENT WHERE ERS_TYPE_ID = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(type)); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();


			ArrayList<Ers_Reimbursment> ReimbursmentList = new ArrayList<Ers_Reimbursment>();
			
			while(rs.next()) { //while there are results left in the ResultSet (rs)
				
				//Create a new Employee Object from each returned record
				//This is the Employee Class's all args constructor
				//And we're filling it with each column of the Employee record
				Ers_Reimbursment er =  new Ers_Reimbursment(
								rs.getInt("REIMB_ID"),
								rs.getInt("REIMB_AMOUNT"),
								rs.getString("REIMB_SUBMITED"),
								rs.getString("REIMB_RESOLVED"),
								rs.getString("REIMB_DESCRIPTION"),
								rs.getString("REIMB_RECIEPT"),
								rs.getInt("REIMB_AUTHOR"),
								rs.getInt("REIMB_RESOLVER"),
								rs.getInt("REIMB_STATUS_ID"),
								rs.getInt("REIMB_TYPE_ID")
								);
				
				ReimbursmentList.add(er);
			}
			return ReimbursmentList;
			}catch (SQLException e) {
				System.out.println("Couldn't get home by name");
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public ArrayList<Ers_Reimbursment> getReimbursmentByUser(int userId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ERS_REIMBURSMENT WHERE ERS_TYPE_ID = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//maybe change to string
			ps.setInt(1,userId); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();


			ArrayList<Ers_Reimbursment> ReimbursmentList = new ArrayList<Ers_Reimbursment>();
			
			while(rs.next()) { //while there are results left in the ResultSet (rs)
				
				//Create a new Employee Object from each returned record
				//This is the Employee Class's all args constructor
				//And we're filling it with each column of the Employee record
				Ers_Reimbursment er =  new Ers_Reimbursment(
								rs.getInt("REIMB_ID"),
								rs.getInt("REIMB_AMOUNT"),
								rs.getString("REIMB_SUBMITED"),
								rs.getString("REIMB_RESOLVED"),
								rs.getString("REIMB_DESCRIPTION"),
								rs.getString("REIMB_RECIEPT"),
								rs.getInt("REIMB_AUTHOR"),
								rs.getInt("REIMB_RESOLVER"),
								rs.getInt("REIMB_STATUS_ID"),
								rs.getInt("REIMB_TYPE_ID")
								);
				
				ReimbursmentList.add(er);
			}
			return ReimbursmentList;
			}catch (SQLException e) {
				System.out.println("Couldn't get home by name");
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public ArrayList<Ers_Reimbursment> getAllReimbursments() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM public.ers_reimbursement ;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//maybe change to string
			//ps.setInt(1,userId); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery();


			ArrayList<Ers_Reimbursment> ReimbursmentList = new ArrayList<Ers_Reimbursment>();
			
			while(rs.next()) { //while there are results left in the ResultSet (rs)
				
				//Create a new Employee Object from each returned record
				//This is the Employee Class's all args constructor
				//And we're filling it with each column of the Employee record
				Ers_Reimbursment er =  new Ers_Reimbursment(
								rs.getInt("REIMB_ID"),
								rs.getInt("REIMB_AMOUNT"),
								rs.getString("REIMB_SUBMITED"),
								rs.getString("REIMB_RESOLVED"),
								rs.getString("REIMB_DESCRIPTION"),
								rs.getString("REIMB_RECEIPT"),
								rs.getInt("REIMB_AUTHOR"),
								rs.getInt("REIMB_RESOLVER"),
								rs.getInt("REIMB_STATUS_ID"),
								rs.getInt("REIMB_TYPE_ID")
								);
				
				ReimbursmentList.add(er);
			}
			return ReimbursmentList;
			}catch (SQLException e) {
				System.out.println("Couldn't all reimbursments");
				e.printStackTrace();
			}
		return null;
	}

}
