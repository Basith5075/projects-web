package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This program demonstrates the life cycle of Servlet. It describes below 5 life cycle stages:
 *		1. Servlet Loading				--- Static Block called
 *		2. Servlet Instantiation		--- Public Constructor called
 *		3. Servlet Initialization		--- init() method called 
 *		4. Request Processing			--- Request Processed [doGet(), doPost() .... methods called]
 *		5. Servlet De-instantiation		--- destroy() method called
 */
public class ServletLifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("First stage Servlet Loading				--- Static Block called");
	}
	public ServletLifeCycle() {
		System.out.println("Second Stage Servlet Instantiation		--- Public Constructor called");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Third Stage Servlet Initialization		--- init() method called ");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Fourth Stage Request Processing			--- Request Processed [doGet(), doPost() .... methods called]");
	}
	
	@Override
	public void destroy() {
		System.out.println("Fifth stage Servlet De-instantiation		--- destroy() method called");
	}

}
