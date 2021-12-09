package co.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/example","root", "Trimax@123");
		String q = "select * from users";
		java.sql.Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(q);
		out.println("<html><body>");
		while(rs.next()) {
			
			String res = rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4);
			
			out.println("<br><hr>"+res);
			out.println("<br><hr>");
		}
		out.println("</html></body>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
