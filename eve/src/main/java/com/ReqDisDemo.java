package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 1. In this example I will exercise the sendRedirect("Redirection Page") method which will redirect the user request to a given page[By using this method the actual page will be still loaded in the client browser]
 * 
 * 2. RequestDispatcher class, methods getRequestDispatcher(), and forward() will also be discussed by using which we can forward the user request internally without letting the end url shown at the client browser URL bar.
 */

@WebServlet(
			urlPatterns = {"/redis"},
			loadOnStartup = -1
		)
public class ReqDisDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("upass");
		RequestDispatcher rd;
//		System.out.println(name);
		if(name.equals("saba")){
//			response.sendRedirect("Reg.jsp?name=saba");
			
			rd = request.getRequestDispatcher("Reg.jsp");
			rd.forward(request, response);
		}else {
//		response.sendRedirect("Welcome.jsp?name="+name);
			rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
			
		}
	}

}
