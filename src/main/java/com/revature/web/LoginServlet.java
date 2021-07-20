package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ErsReimbursmentController;
import com.revature.controllers.LoginController;

public class LoginServlet extends HttpServlet {
	
	
	private LoginController lc = new LoginController();
	//private ErsReimbursmentController ec = new ErsReimbursmentController();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		
		System.out.println("POST");
		lc.login(req, res);
	
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("GET");
		lc.login(req, res);
			

		}
		
//		   res.setContentType("application/json");  
//		    PrintWriter out = res.getWriter();  
//		    out.print("Welcome "); 
//		    ec.getAllReimbursment(res);
		    
		
		
	
}