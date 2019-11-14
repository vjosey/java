package com.skillstorm.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml
public class UserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// <form> <input type="text" name="first-name" /> <input type="text" name="last-name" />
		// first-name=Dan&last-name=Pickles
		String firstName = req.getParameter("first-name");
		String lastName = req.getParameter("last-name");
		
		// generate a page
		resp.getWriter().print("Hello, " + firstName + " " + lastName);
	}
}
