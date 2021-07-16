package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ers_Reimbursment_Type;
import com.revature.services.ErsTypeService;

public class ErsReimbursmentTypeController {
	
	private ErsTypeService tServ = new ErsTypeService();
	private ObjectMapper om = new ObjectMapper();
	
	public void getTypes(HttpServletResponse res) throws IOException{
		
		List<Ers_Reimbursment_Type> typeList = tServ.getAllTypes();
		
		String json = om.writeValueAsString(typeList);
		res.getWriter().print(json);
		res.setStatus(200);
	}

}
