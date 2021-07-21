package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ers_Reimbursment;
import com.revature.services.ErsReimbursmentService;
import com.revature.services.ErsTypeService;

public class ErsReimbursmentController {

	private ErsReimbursmentService rServ = new ErsReimbursmentService();
	
	private ObjectMapper om = new ObjectMapper();
	
	public void getAllReimbursment(HttpServletResponse res) throws IOException{
		
		List<Ers_Reimbursment> typeList = rServ.getAllReimbursment();
		
		String json = om.writeValueAsString(typeList);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	public void getPendingReimbursment(HttpServletResponse res) throws IOException{
		
	///fix this later
	int pending  = 2;
		List<Ers_Reimbursment> list = rServ.Reimbursment(pending);
		
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		//System.out.println(json);
		res.setStatus(200);
	}
public void resolveReimbursment(String date, String id, int resolver,boolean aproved) {
	
	rServ.resolve(date, id, resolver,aproved);
	
	
}
public void createReimbursment(int authorId, int amount, int rType, String description, String date) {
	
	System.out.println(date);
	Ers_Reimbursment temp = new Ers_Reimbursment(amount,date,description,authorId, 2, rType);
	rServ.create(temp);
}
public void getPendingByAuthor(HttpServletResponse res, int author) throws IOException {
	
	System.out.println("checking for id " + author);
	List<Ers_Reimbursment> list = rServ.getPendingByAuthor(author);
	
	String json = om.writeValueAsString(list);
	res.getWriter().print(json);
	res.setStatus(200);
	
	
}
	
}
