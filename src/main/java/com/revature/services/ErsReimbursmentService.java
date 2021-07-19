package com.revature.services;

import java.util.List;

import com.revature.daos.ErsReimbursmentDao;
import com.revature.daos.ErsReimbursmentTypeDao;
import com.revature.models.Ers_Reimbursment;
import com.revature.models.Ers_Reimbursment_Type;

public class ErsReimbursmentService {

	private ErsReimbursmentDao rDao = new ErsReimbursmentDao();
	
	public List<Ers_Reimbursment> getAllReimbursment() {
		
			
			return rDao.getAllReimbursments();
			
		
	}

	public List<Ers_Reimbursment> Reimbursment(int pending) {
		
		return rDao.getReimbursmentByStatus(pending);
	}

}
