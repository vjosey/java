package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skillstorm.beans.Artist;
import com.skillstorm.data.ArtistRepository;

@Controller
public class ArtistController {
	
	@Autowired
	private ArtistRepository repository;

	/**
	 * Spring MVC can map a URL to a method
	 * 
	 * By default, returns a link to a Web page.
	 * Instead, we return data directly in the HTTP response body (@ResponseBody)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/artists", method = RequestMethod.GET)
	public List<Artist> findAll() {
		return repository.findAll();
	}
	
	/**
	 * Find artist in request body and parse it (@RequestBody)
	 * By default: Content-Type of the request is guessed by Spring
	 * consumes: defines the required content-type 
	 * 		(anything else throws 405 Unsupported Media Type)
	 * 
	 * @param artist
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/artist", method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE)
	public Artist save(@RequestBody Artist artist) {
		return repository.save(artist);
	}
	
}






