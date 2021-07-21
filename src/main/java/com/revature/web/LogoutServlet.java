package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.controllers.ErsReimbursmentTypeController;
//import com.revature.controllers.Controller;
import com.revature.controllers.LoginController;

//remember, this is our front controller - ALL requests that come in will have to hit this first.
public class LogoutServlet extends HttpServlet {


	//private LoginController lc = new LoginController();
	//private ErsReimbursmentTypeController typeC = new ErsReimbursmentTypeController();
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		PrintWriter pw = res.getWriter(); //this is how we write to our Response Object
		HttpSession session =req.getSession(false);
		session.invalidate();
		//String URI = req.getRequestURI().replace("/P1-A-Rod1308/", "");
		
		rd = req.getRequestDispatcher("index.html");
		rd.forward(req, res);
		
			
		
		
		
		
		
		///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		// this is the Master!, .* remember to add this to a case
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doPost(req,res); //here, we redirect to the homepage with ""
												//aka the base URL.
												//But you could really put any URL!
		
		//don't forget, all servlets must be declared and mapped in the web.xml.
	}
	
	
	
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, java.io.IOException {
//		
//		doPost(req, res);
//		//this sends every POST request to the doGet method, why???
//		//I only want one switch statement in this Servlet. It can get very messy otherwise
//		//and we'll differentiate get from post in the controllers instead of the servlet.
//		PrintWriter pw = res.getWriter(); //this is how we write to our Response Object
//		
//		pw.print("<h1>Hello from your doPost method</h1>"); //use the PrintWriter to write some HTML
//		
//		res.setStatus(200); 
//		
//	}
	
	
	
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		
//		PrintWriter pw = res.getWriter(); //this is how we write to our Response Object
//		
//		pw.print("<h1>Hello from your doGet method</h1>"); //use the PrintWriter to write some HTML
//		
//		res.setStatus(200); //successful status code - optional, but good to show it working in postman/in general
//		
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		RequestDispatcher rd = null;
//		PrintWriter pw = res.getWriter(); //this is how we write to our Response Object
//		
//		pw.print("<h1>Hello from your doPost method</h1>"); //use the PrintWriter to write some HTML
//		
//		res.setStatus(200); //successful status code - optional, but good to show it working in postman/in general
//		
//		String username = req.getParameter("userId"); 
//		String password = req.getParameter("password");
//		
////		String username = "User";
////		String password = "Pass";
//		if(username.equals("User") && password.equals("Pass")) { 
//			rd = req.getRequestDispatcher("success"); //if the username/password are good, initialize our RequestDispatcher
//			//this "success" parameter is going to be appended to the end of our base URL - to go to SuccessServlet
//			//The SuccessServlet will be the servlet to forward to upon successful login
//			rd.forward(req, res); //we forward the request and response objects to another servlet 
//		} else {
//			rd = req.getRequestDispatcher("index.html"); //if login fails, don't forward, resend the index.html
//			rd.include(req, res); //"this is the request you sent me, this is the page I want to display as a result"
//			pw.print("<p style='color:red'>LOGIN FAILED!</p>"); 
//			//using PrintWriter.print() method to populate HTML in our index.html
//		}
		
	
}