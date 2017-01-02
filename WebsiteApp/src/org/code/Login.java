package org.code;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@SuppressWarnings("unused")
public class Login extends HttpServlet {
	
	private static final String dbusername ="scott";
	private static final String dbpassword ="sys1234";
	
	private static final String dburl ="jdbc:oracle:thin:@localhost:1521:orcl";
	
	private static final String dbClass ="oracle.jdbc.driver.OracleDriver";
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String user = request.getParameter("user_name");
        String pass = request.getParameter("pass_word");
        
        
      //  String username=null;
      /*  
      try {
		username=checkUser(user,pass);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
        
       // username=checkUser();
      
    //  System.out.println("data is being retrived from database : " +username);
        
     // if(username.equals(user))
      try {
		if(checkUser(user,pass))
		    {
		        RequestDispatcher rs = request.getRequestDispatcher("welcome");
		        rs.forward(request, response);
		    }
		    else	
		    {
		       
		       RequestDispatcher rs = request.getRequestDispatcher("Home.html");
		       rs.include(request, response);
		    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }  

	public static boolean checkUser(String user,String pass) throws SQLException{

		boolean value=false;
		  try {
			Class.forName(dbClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  
		 
		//creating connection with the database 
	        Connection con=DriverManager.getConnection
	                       (dburl,dbusername,dbpassword);
	      
	        String sql="select username from authentication where username=? and password=?";
	        
	        PreparedStatement p=con.prepareStatement(sql);
	        p.setString(1, user);
	        p.setString(2, pass);
	        ResultSet rs =p.executeQuery();
	       
	        value =rs.next();
	        
	       /* while(rs.next())
	        {
	        	
	        	 value=rs.getString("USERNAME");
	        	
	        	
	        	System.out.println(value);
	        	
	        	
	        	
	        }*/
			return value;
	        
	      
	}
	
}
