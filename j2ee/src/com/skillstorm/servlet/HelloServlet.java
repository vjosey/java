package com.skillstorm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * To create a servlet:
 * 
 * 1. extend HttpServlet
 * 2. override HTTP methods: doGet doPost doPut.. etc 
 * 3. declare the URL in the /WEB-INF/web.xml
 * 
 * @author PWalsh
 *
 */
public class HelloServlet extends HttpServlet{

	/**
	 * when Tomcat picks up an HTTP GET request for this servlet,
	 * Run this method
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		
		// write directly to the HTTP response body
		/*
		 * PrintWriter out = response.getWriter(); out.println("<h1>Hello World</h1>");
		 * out.println("Current time: " + new Date());
		 */
		response.sendRedirect("hello.jsp");
		
		// declare MIME type
		response.setContentType("text/html");
		
	}
	
}







