package co.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 	ServletException, IOException {
		response.setContentType("text/type");
		ServletOutputStream out = response.getOutputStream();
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_passwd");
		String email = request.getParameter("user_email");
		try {
		Thread.sleep(1500);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/example","root", "Trimax@123");
		
		
		//INSERT into `users` (`user_name`, `user_password`, `user_email`) VALUES (?,?,?);
		
		PreparedStatement ptsmt = con.prepareStatement("INSERT into `users` (`user_name`, `user_password`, `user_email`) VALUES (?,?,?)");
		
		ptsmt.setString(1, name);
		ptsmt.setString(2, password);
		ptsmt.setString(3, email);
		
		ptsmt.executeUpdate();
			out.println("done");
		
		}catch(Exception e) {
			e.printStackTrace();
			out.println("Failed");
		}
	}

}
