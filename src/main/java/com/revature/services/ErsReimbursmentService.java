package com.revature.services;

import java.util.List;

import com.revature.daos.ErsReimbursmentDao;
import com.revature.models.Ers_Reimbursment;

public class ErsReimbursmentService {

	private ErsReimbursmentDao rDao = new ErsReimbursmentDao();
	
	public List<Ers_Reimbursment> getAllReimbursment() {
		
			
			return rDao.getAllReimbursments();
			
		
	}

	public List<Ers_Reimbursment> Reimbursment(int pending) {
		pending = 2;
		return rDao.getReimbursmentByStatus(pending);
	}

	public void resolve(String date, String id, int resolver, boolean aproved) {
		
		rDao.resolve(date,id, resolver, aproved);
		
	}

	public void create(Ers_Reimbursment x) {
		// TODO Auto-generated method stub
		rDao.create(x);
		
	}

	public List<Ers_Reimbursment> getPendingByAuthor(int author) {
		return rDao.getReimbursmentByUser(author);
		
	}

}
