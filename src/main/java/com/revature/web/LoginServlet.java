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
	private ErsReimbursmentController ec = new ErsReimbursmentController();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;  
		PrintWriter out = res.getWriter(); 
		out.print("inPost");
		System.out.println("inPost");
		
		//Set the content type to html to display website
		res.setContentType("text/html");
		
		//get the user inputs from the HTML form, and turn them into Java variables
		String username = req.getParameter("userName"); 
		String password = req.getParameter("userPass");
		String manager = req.getParameter("manager");
		
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(manager);
		
		lc.getAllUsers(res);
		String userType = lc.checkUser(username,password,manager);
		System.out.println("User Type " + userType);
		//Check form data
		
		//if(username.equals("user@mail.com") && password.equals("password")) { 
		if(userType == null) { 
			System.out.println(1);
			out.print("Sorry UserName or Password Error!");  
			res.setContentType("text/html");
			rd = req.getRequestDispatcher("/index.html"); //if login fails, don't forward, resend the index.html
			rd.include(req, res); //"this is the request you sent me, this is the page I want to display as a result"
			
		} else {
			if(userType.equals("M")) {
				
				System.out.println(" loging as a manager");
//				res.setContentType("application/json");
//				ec.getAllReimbursment(res);
				res.setContentType("text/html");
				rd = req.getRequestDispatcher("/app");
				rd.forward(req, res); 
			}else {
				System.out.println("loging as employee");
				res.setContentType("text/html");
				rd = req.getRequestDispatcher("/app");
				rd.forward(req, res); 
			}
	
			

		}
		
//		   res.setContentType("application/json");  
//		    PrintWriter out = res.getWriter();  
//		    out.print("Welcome "); 
//		    ec.getAllReimbursment(res);
		    
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;  
		PrintWriter out = res.getWriter(); 
		out.print("inPost");
		System.out.println("inPost");
		
		//Set the content type to html to display website
		res.setContentType("text/html");
		
		//get the user inputs from the HTML form, and turn them into Java variables
		String username = req.getParameter("userName"); 
		String password = req.getParameter("userPass");
		String manager = req.getParameter("manager");
		
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(manager);
		
		lc.getAllUsers(res);
		String userType = lc.checkUser(username,password,manager);
		System.out.println("User Type " + userType);
		//Check form data
		
		//if(username.equals("user@mail.com") && password.equals("password")) { 
		if(userType == null) { 
			System.out.println(1);
			out.print("Sorry UserName or Password Error!");  
			res.setContentType("text/html");
			rd = req.getRequestDispatcher("/index.html"); //if login fails, don't forward, resend the index.html
			rd.include(req, res); //"this is the request you sent me, this is the page I want to display as a result"
			
		} else {
			if(userType.equals("M")) {
				
				System.out.println(" loging as a manager");
//				res.setContentType("application/json");
//				ec.getAllReimbursment(res);
				res.setContentType("text/html");
				rd = req.getRequestDispatcher("/app");
				rd.forward(req, res); 
			}else {
				System.out.println("loging as employee");
				res.setContentType("text/html");
				rd = req.getRequestDispatcher("/app");
				rd.forward(req, res); 
			}
	
			

		}
		
//		   res.setContentType("application/json");  
//		    PrintWriter out = res.getWriter();  
//		    out.print("Welcome "); 
//		    ec.getAllReimbursment(res);
		    
		
		
	}
}
