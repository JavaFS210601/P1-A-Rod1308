package com.revature.daos;

import java.util.List;

import com.revature.models.Ers_Reimbursment_Type;

public interface Ers_Reimbursment_Type_Interface {
	
	public String getReimbursmentTypeById(int id); 
	public List<Ers_Reimbursment_Type> getAllReimbursmentTypes();

}
