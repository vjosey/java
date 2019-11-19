package org.chinook.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	private ArtistController artistController = new ArtistController();

	protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(req.getRequestURI().contains("hello")) {
			resp.getWriter().append("Artist API. Written by Dan Pickles");
			resp.setStatus(200);
		}
		switch (uri) {
		case "/chinook/api/artist":
			if (req.getMethod().equals("POST")) {
				artistController.postArtist(req, resp);
				return;
			}
			if (req.getMethod().equals("PUT")) {
				artistController.putArtist(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				artistController.getArtist(req, resp);
				return;
			}
			if (req.getMethod().equals("DELETE")) {
				artistController.deleteArtist(req, resp);
				return;
			}

		default:
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Front Controller Initialized!");
	}

}
