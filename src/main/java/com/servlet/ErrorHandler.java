package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandler
 */

public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Throwable throwable=(Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode=(Integer) request.getAttribute("javax.servlet.error.status_code");
	    String servletName=(String) request.getAttribute("javax.servlet.error.servlet_name");
	    if(servletName==null) {
	    	servletName="Unknown";
	    }
	    String requestUri=(String) request.getAttribute("javax.servlet.error.request_uri");
	    if(requestUri==null) {
	    	requestUri ="Unknown";
	    }
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	   out.println("<html><head><title>Exception/Error Details</title></head><body>");
	    if(throwable==null && statusCode==null) {
	    	out.println("Error info missing");
	    	out.println("Please return to <a href=\""+ response.encodeURL("http://localhost:8080/")+"\">Home Page</a>.");
	    	
	    }
	    
	    else if(statusCode != 500){
	    	  out.println("<h3>Error Details</h3>");
	    	  out.println("<strong>Status Code</strong>:"+statusCode+"<br>");
	    	  out.println("<strong>Requested URI</strong>:"+requestUri);
	      }
	    else {
	    	out.println("Exception Details");
	    	out.println("Servlet Name"+servletName);
	    	out.println("Exception name:"+throwable.getClass().getName());
	    	 out.println("Requested URI:"+requestUri);
	    	 out.println("Exception mesage:"+throwable.getMessage());
	    }
	    out.println("</body>");
	     out.println("</html>"); 	 
	}    
	    

}
