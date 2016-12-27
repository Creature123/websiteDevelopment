package org.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
		// TODO Auto-generated method stub
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			 response.setContentType("text/html;charset=UTF-8");
		     @SuppressWarnings("unused")
			PrintWriter out = response.getWriter();
		     
		     RequestDispatcher rd = request.getRequestDispatcher("WelcomePage.html");
	         rd.include(request, response);
			
		}
	}

