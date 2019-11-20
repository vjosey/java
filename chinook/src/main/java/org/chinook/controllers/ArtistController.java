package org.chinook.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chinook.beans.Artist;
import org.chinook.service.ArtistService;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ArtistController {

	private ArtistService artistService = new ArtistService();

	// POST /chinook/api/artist
	public void postArtist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.getWriter().println(new ObjectMapper().writeValueAsString(
				artistService.save(new ObjectMapper().readValue(req.getInputStream(), Artist.class))));
		// headers
		resp.setStatus(201);
	}

	// GET /chinook/api/artist?id=1
	public void getArtist(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		if (req.getParameter("id") != null) {
			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(artistService.findByArtistId(Integer.parseInt(req.getParameter("id")))));
		} else if (req.getParameter("name") != null) {
			resp.getWriter().println(
					new ObjectMapper().writeValueAsString(artistService.searchByName(req.getParameter("name"))));
		} else {
			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(artistService.findAll()));
		}
	}

	// PUT /chinook/api/artist
	public void putArtist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		artistService.update(new ObjectMapper().readValue(req.getInputStream(), Artist.class));
		resp.setStatus(204);
		
	}

	// DELETE /chinook/api/artist?id=1
	public void deleteArtist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		artistService.delete(Integer.parseInt(req.getParameter("id")));
		resp.setStatus(204);
	}

}
