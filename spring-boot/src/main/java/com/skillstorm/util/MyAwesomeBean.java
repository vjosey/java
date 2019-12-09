package com.skillstorm.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class MyAwesomeBean {
	
	private static final Logger log = Logger.getGlobal();
	
	public MyAwesomeBean() {
		log.log(Level.INFO, this.hello());
		log.log(Level.FINEST, "I am in this method");
	}

	public String hello() {
		return "Hello Spring Boot";
	}
	
}
