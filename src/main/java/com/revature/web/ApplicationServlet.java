package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ErsReimbursmentController;
import com.revature.controllers.ErsReimbursmentTypeController;

public class ApplicationServlet extends HttpServlet {
	 
	   private ErsReimbursmentController ec = new ErsReimbursmentController();
	   private ErsReimbursmentTypeController tc = new ErsReimbursmentTypeController();
	   
	   public void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {  
		    RequestDispatcher rd = null; 
		    res.setContentType("application/json");  
		    PrintWriter out = res.getWriter();  
		    
		    
		          
		 //   String n=req.getParameter("userName");  
		    out.print("Welcome "); 
		    //tc.getTypes(res);
		    ec.getAllReimbursment(res);
		    
		  //  rd = req.getRequestDispatcher("/app.html"); //if login fails, don't forward, resend the index.html
			//rd.include(req, res);
		    }  
	   
	   public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {  
		    RequestDispatcher rd = null; 
		    res.setContentType("application/json");  
		    PrintWriter out = res.getWriter();  
		    
		    
		    
		          
		 //   String n=req.getParameter("userName");  
		  //  out.print("Welcome "); 
		    //tc.getTypes(res);
		    ec.getAllReimbursment(res);
		  //  rd = req.getRequestDispatcher("/app.html"); //if login fails, don't forward, resend the index.html
			//rd.include(req, res);
		    }

}
