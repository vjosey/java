package org.chinook.service;

import java.util.List;
import java.util.Set;

import org.chinook.beans.Artist;
import org.chinook.data.ArtistDAO;

public class ArtistService {

	private ArtistDAO artistDAO = new ArtistDAO();
	
	public Artist save(Artist artist) {
		return artistDAO.save(artist);
	}

	public Artist findByArtistId(int id) {
		return artistDAO.findByArtistId(id);
	}

	public List<Artist> findAll() {
		return artistDAO.findAll();
	}

	public Set<Artist> searchByName(String search) {
		return artistDAO.searchByName(search);
	}

	public void update(Artist artist) {
		artistDAO.update(artist);
	}

	public void delete(int id) {
		artistDAO.delete(id);
	}
	
}
