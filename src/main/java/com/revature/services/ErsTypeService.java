package com.revature.services;


import java.util.List;

import com.revature.daos.ErsReimbursmentTypeDao;
import com.revature.models.Ers_Reimbursment_Type;

public class ErsTypeService {
	
	private ErsReimbursmentTypeDao tDAO = new ErsReimbursmentTypeDao();

	public String getTypeById() {
		
		return tDAO.getReimbursmentTypeById(2);
		
	}
	
	public List<Ers_Reimbursment_Type> getAllTypes() {
		
		return tDAO.getAllReimbursmentTypes();
		
	}

}
