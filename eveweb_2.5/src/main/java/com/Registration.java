package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 	ServletException, IOException {
		
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		String gender = request.getParameter("user_gender");
		String course = request.getParameter("user_course");
		String condition = request.getParameter("condition");
		
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		if(condition!=null) {
			out.println("User Name : "+name);
			out.println("<br>User Password : "+password);
			out.println("<br>User Email : "+email);
			out.println("<br>User Gender : "+gender);
			out.println("<br>User Course : "+course);
		}
		else {		
			out.println("<html style = 'background-color: red'>Please Accept the License</html>");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
			rd.include(request, response);
		}	
		
	}

}
