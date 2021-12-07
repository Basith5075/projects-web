package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * This is a very IMP execice of Sessions. We use the HttpSession obj to get the details of the present session such as sessionId and we use logic with the methods setAttribute(String,Value) and getAttribute(String) to know the number of requests sent in a session from same client
 * 
 */

@WebServlet("/session")
public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletOutputStream out = response.getOutputStream();
		out.println("<h1> Your session ID is "+session.getId()+"</h1><hr>");
	
		if(session.isNew()) {
			out.println("<h3>You haved logged in for First Time</h3>");
			session.setAttribute("counter", 1);
		}else {
			Object obj= session.getAttribute("counter");
			int count = Integer.parseInt(obj.toString())+1;
			out.println(obj +"<h3>You haved logged in for "+count +" Time</h3>");
			session.setAttribute("counter", count);
		
			
		}
		
//		out.println("<h3>You haved logged in for "+counter+" times </h3>");
		
	}

}
