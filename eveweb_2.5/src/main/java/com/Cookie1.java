package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
//		HttpSession session = request.getSession();
//		session.setAttribute("name", name);
		
		Cookie c = new Cookie("name", name);
		response.addCookie(c);
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<h2> Welcome Mr. "+name+"</h2>");
		
		out.println("<a href='./cookie2'> Go To Servlet 2</a>");
		out.println();
	}

}
