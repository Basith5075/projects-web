package co.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Testing {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/example","root", "Trimax@123");
			
			
			//INSERT into `users` (`user_name`, `user_password`, `user_email`) VALUES (?,?,?);
			
			PreparedStatement ptsmt = con.prepareStatement("INSERT into `users` (`user_name`, `user_password`, `user_email`) VALUES (?,?,?)");
			
			ptsmt.setString(1, "basith");
			ptsmt.setString(2, "trimax");
			ptsmt.setString(3, "basith@gmail.com");
			
			int res = ptsmt.executeUpdate();
			System.out.println(res+" No of Rows Inserted Successully !!");
			
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Insertion failed !!");
			}

	}

}
