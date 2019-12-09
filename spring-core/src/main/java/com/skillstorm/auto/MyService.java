package com.skillstorm.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Stereotype annotations: automatically register this as a bean
 * with the Spring container
 * @author PWalsh
 *
 */
@Service(value = "dan") // @Bean(name="dan")
public class MyService {
	@Autowired
	private MyDao dao;
	@Autowired
	private MyUtil util;
	
}


