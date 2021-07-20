package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ers_User;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {
	ObjectMapper om = new ObjectMapper(); //so we can work with JSON
	private LoginService ls = new LoginService();
	private RequestDispatcher rd = null;
	//private ArrayList<Ers_User> users = new ArrayList<Ers_User>();
	
	
	public void login2(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
			
			//this process below is to get our JSON String
			
			BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
			
			StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
			
			String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
			
			while(line != null) { //while there is data to read from the response data (res -> reader -> line)
				
				sb.append(line); //add the contents of "line" to the StringBuilder
				line = reader.readLine(); //assign line to the next line of data in the reader
				
				//so for every line of data that received from the response, 
				//we want to append it to the StringBuilder 
				//So we get all this previously JSON into one StringBuilder object. Parsing JSON into Java!!
			}
			
			//ObjectMapper only works with Strings... (not StringBuilders...)
			String body = new String(sb); //so we make a new String to hold the StringBuilder content
			
			//Use the ObjectMapper to read our JSON username/password (which is now a Java String) 
				//remember the readValue() method of ObjectMapper turns JSON into Java
			//and put it into a LoginDTO class as fields
			LoginDTO lDTO = om.readValue(body, LoginDTO.class); //we created a LoginDTO using the JSON-turned-Java
			
			
			//control flow to determine what happens in the event of a successful/unsuccessful login--------
			
			if(ls.login(lDTO.username, lDTO.password)) { //if the username/password sent to the service are valid...
				
				HttpSession ses = req.getSession(); //return a Session to hold user info (if one doesn't exist yet)
				//remember, sessions are how you remember the different users on the client
	

//				
//					Cookie[] cookies = req.getCookies();
//					for (cookie : cookies) {
//						info.log(cookie);
//					}
//				
//				); //this is how I'd assume you can log cookies, getCookies returns an array
				
				//this info stays on the server, all the client gets is the request's cookie created by getSession()
				//when a user gets a session, they get a cookie returned that uniquely identifies their session
				ses.setAttribute("user", lDTO); //we'll probably just use a USer object if this was forreal
				ses.setAttribute("loggedin", true);
				
		
				res.setStatus(200); //because login was successful
				res.getWriter().print("Hi Login was successful"); //we won't see this message anywhere but postman
				
			} else {
				HttpSession ses = req.getSession(false); //this will only return a session if one is already active
				
				if(ses != null) { //if a session exists...
					ses.invalidate(); //kill the session
				}
				
				res.setStatus(401); //unauthorized
				res.getWriter().print("Login Invalidated"); //we won't see this message anywhere but postman
					
			}
			
		}
		
	}

	
	
	public void getAllUsers(HttpServletResponse res) throws IOException{
		
		System.out.println("Callig the service");
		ArrayList<Ers_User> list = ls.getAllUser();
		//users = list;
		
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}

//	public String checkUser(String username, String password, String isManager,HttpServletRequest req) {
//		
//		System.out.println("IM CHEKING THE USER");
//		//System.out.println(users.size());
//		
//		for(int i = 0; i < users.size(); i++) {
//			System.out.println(users.get(i).toString());
//			if(username.equals(users.get(i).user_email) && password.equals(users.get(i).ers_password)) {
//				HttpSession session =req.getSession();
//				session.setAttribute("userId", users.get(i).ers_user_id);
//				if(users.get(i).user_rolde_id == 1 && isManager.equals("manager")) {return "M";}
//				if(users.get(i).user_rolde_id == 0 && isManager == null) {return "E";}
//			}
//			
//		}
//		
//		return null;
//	}
	
	//-1 = no user, 0 = employee, 1= manager
	//public void login(String username, String password, String isManager,HttpServletRequest req) {
		public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		System.out.println("Controller Is Checking for User");
		ArrayList<Ers_User> users = ls.getAllUser();
		String json = om.writeValueAsString(users);
		res.getWriter().print(json);
		res.setStatus(200);
		String username =req.getParameter("userName");
		String password =req.getParameter("userPass");
		String temp = req.getParameter("manager");
		boolean isManager = temp == null ? false : true;
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(isManager);
		
		
		System.out.println("===============\nChecking User List\n===========");
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toString());
			if(username.equals(users.get(i).user_email) && password.equals(users.get(i).ers_password)) {
				HttpSession session =req.getSession();
				session.setAttribute("userId", users.get(i).ers_user_id);
				System.out.println(users.get(i).ers_user_id);
				System.out.println("/*/*/*/*/*/*/*/*/*");
				if(users.get(i).user_rolde_id == 1 && isManager) {
					res.setContentType("text/html");
					rd = req.getRequestDispatcher("/app.html"); //rederect
					rd.forward(req, res);
					}
				if(users.get(i).user_rolde_id == 0 && !isManager) {
					res.setContentType("text/html");
					rd = req.getRequestDispatcher("/app.html"); //rederect
					rd.forward(req, res);
					}
				
				///next up rederect end test
			}
			else {
				PrintWriter out = res.getWriter();
				res.setContentType("text/html");
				out.print("Incorect credentials, Please try again");
				rd = req.getRequestDispatcher("index.html");
				rd.include(req, res);
			}
			
		}
		
		
	}
}
