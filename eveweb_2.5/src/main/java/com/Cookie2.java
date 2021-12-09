package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Cookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
		
//		HttpSession session = request.getSession();
//		String uname = (String)session.getAttribute("name");
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		
		Cookie[] cookies = request.getCookies();
		String name = "";
		boolean f = false;
		
		if(cookies == null) {
			out.println("You are a new Visitor, Kindly Register before starting session");
			return;
		}else {
			for(Cookie c:cookies) {
				String cname = c.getName();
				if(cname.equals("name")) {
					f = true;
					name = c.getValue();
				}
			}		
		}
		if(f) {
		out.println("<h2> Welcome Back Mr "+name+"</h2");
		}
		
	}

}
