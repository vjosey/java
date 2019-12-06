package com.skillstorm.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.beans.Artist;
import com.skillstorm.data.ArtistRepository;

// @Controller
@RestController // @Controller.. applies @ResponseBody to every single method in the class
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") // Spring 4.3
// same as our CORSFilter (applies to just THIS controller)
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
	//@ResponseBody
	//@RequestMapping(value = "/artists", method = RequestMethod.GET)
	@GetMapping(value = "/artists")
	public ResponseEntity<List<Artist>> findAll() {
		return new ResponseEntity<List<Artist>>(repository.findAll(), HttpStatus.OK);
	}
	
	/**
	 * Find artist in request body and parse it (@RequestBody)
	 * By default: Content-Type of the request is guessed by Spring
	 * consumes: defines the required content-type 
	 * 		(anything else throws 415 Unsupported Media Type)
	 * 
	 * @param artist
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/artist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value = "/artists/artist", consumes = MediaType.APPLICATION_JSON_VALUE)
					// @Valid (validate the request body against JSR-303 annotations)
	public ResponseEntity<Artist> save(@Valid @RequestBody Artist artist) {
		// ResponseEntity (manipulate the HttpResponse)
		// generic means the type of obj in the response body <Artist>
		// body (json), HttpStatus, HttpHeaders
		ResponseEntity<Artist> response = 
				new ResponseEntity<Artist>(repository.save(artist), HttpStatus.CREATED); 
		// HttpStatus.CREATED === 201 
		return response;
	}
	
	// /artists/artist/1    (resource identifier) 
	// passing a variable inside the path (URL)
	@GetMapping(value = "/artists/artist/{id}")
	public Artist getById(@PathVariable int id) {
		Optional<Artist> opt = repository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return new Artist(); 
			// return null will result in someone having to handle errors
		} 
	}
	
	// extract a parameter from the URL via @RequestParam
	// /artists/artist?name=Z
	@GetMapping(value = "/artists/artist")
	public List<Artist> searchByName(@RequestParam String name) {
		return repository.findByNameLike(name);
	}
	
	@GetMapping(value = "/genre/{genre}/artists/artist/{id}")
	public Artist getById(@PathVariable int id, @PathVariable(name = "genre") String g) {
		// logic
		return new Artist();
	}
	
}






