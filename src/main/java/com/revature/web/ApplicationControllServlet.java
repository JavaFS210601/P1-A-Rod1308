package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.controllers.ErsReimbursmentController;
import com.revature.controllers.LoginController;

/**
 * Servlet implementation class ApplicationControllServlet
 */
@WebServlet({ "/ApplicationControllServlet", "/app2", "/app-pending-M", "/app-pending-E", "/app-resolved-M", "/app-resolved-E", "/app-create", "/app-byDate" })
public class ApplicationControllServlet extends HttpServlet {
	//private LoginController lc = new LoginController();
	private ErsReimbursmentController ec = new ErsReimbursmentController();
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;
	
	
    public ApplicationControllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		String URI = request.getRequestURI().replace("/P1-A-Rod1308/", "");
		switch(URI) {
		case "app":
			System.out.println("app1");
		break;
		case "app-pending-M":
			doPost(request,response);
			
			System.out.println("app2");
		break;
		case "app-pending-E":
			System.out.println("app3");
		break;
		case "app-resolved-M":
			System.out.println("app4");
		break;
		case "app-resolved-E":
			System.out.println("app5");
		break;
		case "app-create":
			System.out.println("app6");
		break;
		case "app-byDate":
			System.out.println("app7");
		break;
		
		}
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("isManager"));
		//session.getAttribute("isManager");
		
		response.setContentType("text/html");
		if ((Boolean)session.getAttribute("isManager"))
			rd = request.getRequestDispatcher("/appManager.html");
		else
			rd = request.getRequestDispatcher("/app.html");
		
		
		
	    
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IIIIIIIIIIIINNNNNNNNNNNN dddddddddddooooooooo post");
		response.setContentType("application/json");
	    ec.getPendingReimbursment(response);
	}

}
