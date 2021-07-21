package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ErsReimbursmentController;

/**
 * Servlet implementation class ApplicationManagerServlet
 */
@WebServlet({ "/ApplicationManagerServlet", "/appmanager" })
public class ApplicationManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private ErsReimbursmentController ec = new ErsReimbursmentController();
//	   private ErsReimbursmentTypeController tc = new ErsReimbursmentTypeController();
	   
	   RequestDispatcher rd = null; 
	   
	   public void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {  
		   
		    res.setContentType("application/json");
		//    ec.getAllReimbursment(res);
		    ec.getPendingReimbursment(res);
		    
		    res.setContentType("text/html");
		    rd = req.getRequestDispatcher("/appManager.html");
		   // System.out.println("in do post");
		    rd.forward(req, res);
//		    
		    //res.setContentType("application/json");  
		    doGet(req,res);
		    
		    System.out.println("-=-=-=-=-=-=-=IN DO POST");
		    }  
	   
	   public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {  
//		    
		   res.setContentType("application/json");
		    //ec.getAllReimbursment(res);
		    ec.getPendingReimbursment(res);
		    System.out.println("-=-=-=-=-=-=-=IN DO Get");
//	  
	   }

}
