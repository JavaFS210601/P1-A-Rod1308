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
//	   private ErsReimbursmentTypeController tc = new ErsReimbursmentTypeController();
	   
	   RequestDispatcher rd = null; 
	   
	   public void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {  
		   
		    res.setContentType("application/json");
		//    ec.getAllReimbursment(res);
		    ec.getPendingReimbursment(res);
		    
		    res.setContentType("text/html");
		    rd = req.getRequestDispatcher("/app.html");
		    System.out.println("in do post");
		    rd.forward(req, res);
//		    
		    //res.setContentType("application/json");  
		   // doGet(req,res);
		    
		    System.out.println("IN DO POST");
		    }  
	   
	   public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {  
//		    res.setContentType("application/json");  
//		    PrintWriter out = res.getWriter();  
//		   ec.getAllReimbursment(res);
		    //res.setContentType("application/json");  
		   // PrintWriter out = res.getWriter();  
		    //out.print("Welcome "); 
		   res.setContentType("application/json");
		    //ec.getAllReimbursment(res);
		    ec.getPendingReimbursment(res);
//	   res.setContentType("application/json");
//	    ec.getAllReimbursment(res);
//	    res.setContentType("text/html");
//	    rd = req.getRequestDispatcher("/app.html");
//	    System.out.println("in do get");
//	    rd.forward(req, res);
	   }
}
