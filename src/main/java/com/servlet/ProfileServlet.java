package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */

public class ProfileServlet extends HttpServlet {
	
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html");
			
			PrintWriter out=response.getWriter();
			request.getRequestDispatcher("link.html").include(request, response);
			HttpSession session=request.getSession(false);
			if(session!=null) {
				String name= (String) session.getAttribute("name");
				
					out.print("<br> Welcome to your profile");
					out.print("<br> Welcome "+name);
				
				}
				else {
					out.print("<br>please login first");
					request.getRequestDispatcher("login.html").include(request,response);
				}
			out.close();
			
			
			}catch(Exception e) {
		System.out.println(e);
	}

}
}
