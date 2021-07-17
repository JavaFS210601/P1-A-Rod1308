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
	
}
