package com.revature.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.controllers.ErsReimbursmentController;

/**
 * Servlet implementation class ResolveServlet
 */
@WebServlet({ "/ResolveServlet", "/resolve","/create" })
public class ResolveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    private ErsReimbursmentController rc = new ErsReimbursmentController();
    public ResolveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//PrintWriter out = res.getWriter();
		System.out.println("=================================(in DOGet)");
		doPost(req,res);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String URI = req.getRequestURI().replace("/P1-A-Rod1308/", "");
		
		switch(URI) {
		case"resolve":
				resolve(req);
			break;
		case"create":
				create(req);
			break;
		
		}
		
		
		
		rd = req.getRequestDispatcher("/app");
		rd.include(req, res);
	}
	
	private void resolve(HttpServletRequest req) {
		
		String date = req.getParameter("date");
		String id = req.getParameter("idSelect");
		
		HttpSession session = req.getSession(false);
		int resolverId = (Integer)session.getAttribute("userId");
		
		
		
		String temp = req.getParameter("aprove");
		boolean aproved ;
		aproved = temp == null ? false : true;
		
	
		
		System.out.println(date + " id: " + id +"Sesion"+ "R:" + resolverId) ;
		System.out.println("()()()()()()()\n\n");
		
		
		rc.resolveReimbursment(date, id, resolverId,aproved);
		
	}
	
	private void create(HttpServletRequest req) {
		
		int amount = Integer.valueOf(req.getParameter("amount")); 
		int  rType = Integer.valueOf(req.getParameter("rType"));
		String description = req.getParameter("description");
		System.out.println(amount + " " + rType + " " + description);
		
		HttpSession session = req.getSession(false);
		int authorId = (Integer)session.getAttribute("userId");
		System.out.println("===========" + authorId + "==============");
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		
		rc.createReimbursment(authorId,amount, rType, description, formatter.format(date));
		
		
		
	}

}
