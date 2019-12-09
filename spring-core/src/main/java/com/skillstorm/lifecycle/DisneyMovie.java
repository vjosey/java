package com.skillstorm.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan
public class DisneyMovie {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(DisneyMovie.class);
		context.getBean(Lion.class).roar();
		context.getBean(Lion.class).makeFriend();
		context.registerShutdownHook(); // shutdown gracefully, destroy beans
		context.close();
	}
	
}
