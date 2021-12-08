package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		int nn1 = Integer.parseInt(n1);
		int nn2 = Integer.parseInt(n2);
		
		int sum = nn1+nn2;
		
		HttpSession session = request.getSession();
		session.setAttribute("sum", sum);
		
		RequestDispatcher rd = request.getRequestDispatcher("s2");
		rd.forward(request, response);
		}

}
