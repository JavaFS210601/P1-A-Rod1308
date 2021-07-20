package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.revature.controllers.ErsReimbursmentController;
import com.revature.controllers.LoginController;

public class LoginServlet extends HttpServlet {
	
	
	private LoginController lc = new LoginController();
	//private ErsReimbursmentController ec = new ErsReimbursmentController();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		
		System.out.println("POST");
		HttpSession session =req.getSession();
//		session.setAttribute("userId", 1);
//		session.setAttribute("fName", 2);
//		session.setAttribute("lName", 3);
//		session.setAttribute("isManager", 4);
		System.out.println((String)session.getId());
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