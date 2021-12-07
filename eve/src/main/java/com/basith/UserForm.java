package com.basith;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserForm
 */
@WebServlet("/UserForm")
public class UserForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String address = request.getParameter("addr");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		int age = Integer.parseInt(request.getParameter("age"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>");
		out.println("Below are the details submitted by you !!</h2>");
		out.println("Name            : "+name+"<br>");
		out.println("Address         : "+address+"<br>");
		out.println("Pincode         : "+pincode+"<br>");
		out.println("Age             : "+age+"<br>");
		out.println("</body></html>");
		
	}

}
