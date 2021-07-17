package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;  
		PrintWriter out = res.getWriter(); 
		
		//Set the content type to html to display website
		res.setContentType("text/html");
		
		//get the user inputs from the HTML form, and turn them into Java variables
		String username = req.getParameter("userName"); 
		String password = req.getParameter("userPass");
		

		 
		          
		//Check form data
		
		if(username.equals("user@mail.com") && password.equals("password")) { 
			
			//Uri Endpoint
			
			rd = req.getRequestDispatcher("app.html");
			//Forward a request to another resourse on the server
			rd.forward(req, res); 
		} else {
			out.print("Sorry UserName or Password Error!");  
			rd = req.getRequestDispatcher("/index.html"); //if login fails, don't forward, resend the index.html
			rd.include(req, res); //"this is the request you sent me, this is the page I want to display as a result"

		}
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		PrintWriter pw = res.getWriter(); //this is how we write to our Response Object
		
		pw.print("<h1>Hello from your doGet method</h1>"); //use the PrintWriter to write some HTML
	}
}
