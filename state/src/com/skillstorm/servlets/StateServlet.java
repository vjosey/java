package com.skillstorm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// accessing cookies (pre-Java EE 7)
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("hello-cookie")) {
					// cookie has already been created
					System.out.println("Replacing old cookie value: " + cookie.getValue());
				}
			}
		}
		// Cookie cookie = req.getCookie("hello-cookie"); // Java EE 7

		// creating cookies
		Cookie cook = new Cookie("hello-cookie", req.getParameter("cookie"));
		cook.setMaxAge(2_000_000_000); // expiry
		resp.addCookie(cook);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// session
		// get the session if there is one. create a new session if there isn't one
		System.out.println(req.getSession().getAttribute("attr"));
		req.getSession().setAttribute("attr", req.getParameter("session"));
		System.out.println(req.getSession().getAttribute("attr"));
	}

}











