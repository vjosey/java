package com.skillstorm.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Stereotype annotations: automatically register this as a bean
 * with the Spring container
 * @author PWalsh
 *
 */
@Controller
public class MyController {
	@Autowired
	@Qualifier("dan") // autowire byName (default: byType)
	// Qualifier looks for a bean with that specific name
	private MyService service;

	public MyService getService() {
		return service;
	}
	
}
