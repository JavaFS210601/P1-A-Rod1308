package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationServlet extends HttpServlet {
	
	   public void doPost(HttpServletRequest req, HttpServletResponse res)  
		        throws ServletException, IOException {  
		    RequestDispatcher rd = null; 
		    res.setContentType("text/html");  
		    PrintWriter out = res.getWriter();  
		    
		          
		    String n=req.getParameter("userName");  
		    out.print("Welcome "+n); 
		    rd = req.getRequestDispatcher("/app.html"); //if login fails, don't forward, resend the index.html
			rd.include(req, res);
		    }  

}
