package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;

public class MasterServlet extends HttpServlet{
	
	private LoginController lc = new LoginController();
	private RequestDispatcher rd = null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("application/json");
		res.setStatus(404);
		System.out.println("Master set to 404");
		String URI = req.getRequestURI().replace("/P1-A-Rod1308/", "");
		System.out.println(URI+ "======================");
		if(URI == "") {
			res.setStatus(200);
			res.setContentType("text/html");
			rd = req.getRequestDispatcher("/index.html"); //rederect
			rd.forward(req, res);
		}else {
			switch(URI) {
			case "signout" :
				System.out.println(URI + "++++++++++signout");
			case "login":
				System.out.println(URI+ "====================== in case");
//				res.setStatus(200);
//				res.setContentType("text/html");
//				rd = req.getRequestDispatcher("/index.html"); //rederect
//				rd.forward(req, res);
				//provide Service & break
				lc.login(req, res);
				
				break;
			case "second":
				//provide Service & break
				System.out.println(URI);
				break;
			}
		}
			
		
		
	
	}
		
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	System.out.println("Master is posting");
	doGet(req, res);
	}
}
