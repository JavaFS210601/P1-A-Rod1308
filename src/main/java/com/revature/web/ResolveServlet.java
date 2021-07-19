package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.revature.controllers.ErsReimbursmentController;

/**
 * Servlet implementation class ResolveServlet
 */
@WebServlet({ "/ResolveServlet", "/resolve" })
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
		// TODO Auto-generated method stub
		
		//res.setContentType("text/html");
		RequestDispatcher rd = null;
		PrintWriter out = res.getWriter();
		
		String date = req.getParameter("date");
		String id = req.getParameter("idSelect");
		
		HttpSession session = req.getSession(false);
		int resolverId = (Integer)session.getAttribute("userId");
		
		
		
		String temp = req.getParameter("aprove");
		boolean aproved ;
		aproved = temp == null ? false : true;
		
		System.out.println(temp);
		System.out.println(aproved);
		
		//boolean aproved = false;
		//System.out.println("()()()()()()()()"+resolverId);
		
		System.out.println(date + " id: " + id +"Sesion"+ "R:" + resolverId) ;
		System.out.println("()()()()()()()\n\n");
		
		
		System.out.println("=======================================(in doPost)");
		//out.println("<p style='color:red;'>Yay!</p>");
		
		
		rc.resolveReimbursment(date, id, resolverId,aproved);
		
		rd = req.getRequestDispatcher("/app");
		rd.include(req, res);
	}

}
