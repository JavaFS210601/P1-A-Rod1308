package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Ers_Reimbursment;

public interface Ers_Reimbursment_Interface {
	
	
		public Ers_Reimbursment getReimbursmentById(int id);
		
		
		//for manager
		
		public ArrayList<Ers_Reimbursment> getReimbursmentByStatus(int status);
		
		public ArrayList<Ers_Reimbursment> getReimbursmentByType(int type);
		
		//for employee
		
		public ArrayList<Ers_Reimbursment> getReimbursmentByUser(int userId);
		
		public ArrayList<Ers_Reimbursment> getAllReimbursments();
		
		public void resolve(String date, String reimbId, int resolverId, boolean aproved);
}
