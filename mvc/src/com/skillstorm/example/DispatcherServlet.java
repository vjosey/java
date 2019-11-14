package com.skillstorm.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Front Controller Design Pattern:
 * 
 * One servlet - only one servlet
 * Captures all requests.. 
 * Proxies requests to the specific controller
 * Returns results/performs redirection
 * 
 * @author PWalsh
 *
 */
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Dispatcher received url: " + req.getRequestURL());
		//    /mvc/api/route-1  
		switch (req.getRequestURI()) {
		case "/mvc/api/route-1":
			// proxy request to another controller
			new OtherController().getSomeData();
			//resp.getWriter().print(objectMapperMagic); // return JSON
			resp.sendRedirect("/mvc/one.html"); // tells client to GET this page
			break;
		case "/mvc/api/route-2":
			// happening all the server-side (within the application)
			// forward: servlets/JSPs
			req.setAttribute("attr", new Object());
			// only forward within the same app.. /mvc is implied (context root)
			req.getRequestDispatcher("/two.html").forward(req, resp);
			break;
		default:
			break;
		}
		
	}
	
}
