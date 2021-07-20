package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;

/**
 * Servlet implementation class SignUp
 */
@WebServlet({ "/SignUp", "/signup" })
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginController lc = new LoginController();
	
	private  RequestDispatcher rd = null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("////////////do get");
		res.setContentType("text/html");
		rd = req.getRequestDispatcher("/signup.html");
		rd.forward(req, res);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("////////////do post");
		lc.createNewUser(req,res);
		//doGet(request, response);
	}

}
