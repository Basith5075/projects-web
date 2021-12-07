package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
			urlPatterns = {"/basic"},
			loadOnStartup=-1,
			initParams= {
					@WebInitParam(name = "driver", value="com.mysql"),
					@WebInitParam(name = "myurl", value="chttp://fldjsaklfj.com"),
					@WebInitParam(name="configfile", value="/WEB-INF/dbconfig.properties")
					
			}
		
		)
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("Static Block ---- Servlet Loading ...");
	}
       @Override
    public void init(ServletConfig config) throws ServletException {
    	   	System.out.println("From init called ---- Servlet Initialization");
    	   	String name = config.getInitParameter("driver");
    	   	System.out.println(name);
    	   	String myurl = config.getInitParameter("myurl");
    	   	System.out.println(myurl);
    	   	String path = config.getInitParameter("configfile");
    	   	System.out.println(path);
    	   	ServletContext application = config.getServletContext();
    	   	String fullpath = application.getRealPath(path);
    	   	System.out.println("Full path = "+fullpath);
    	   	try {
    	   		Properties prop = new Properties();
//    	   		prop.load(new FileInputStream("D:\\Java Learning\\web-projects\\eveweb\\src\\main\\webapp\\dbconfig.properties"));
//    	   		System.out.println("Driver From Prop Files "+prop.get("driver"));
    	   	}catch(Exception e) {
    	   		e.printStackTrace();
    	   	}
    	   	
       }
       public BasicServlet() {
    	   	System.out.println("From Constructor -- Servlet Instantiation");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Processing ");
		String uname = request.getParameter("name");
		String upass = request.getParameter("upass");
		System.out.println(uname+" ::: "+upass);
		
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		out.println("<html><body>");
		out.println("<h2>");
		out.println("name = "+uname);
		out.println("password = "+upass);
		out.println("</h2>");
		out.println("</body></html>");
		
		
	}
@Override
		public void destroy() {
			System.out.println("Servlet DeInstantiation");
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
