package com.skillstorm.spring;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.skillstorm.beans.Crayon;
import com.skillstorm.beans.Pencil;
import com.skillstorm.beans.Person;
import com.skillstorm.beans.WritingUtensil;

/**
 * Annotation-based configuration class for Spring
 * 
 * Configure beans in my Spring Container
 * 
 * Bean Wiring
 * 
 * @author PWalsh
 *
 */
@Configuration
public class HelloConfiguration {

	/**
	 * Create a person, and return it to Spring Container.
	 * 
	 * Dependency Injections: 
	 * 	1) setter injection
	 * 	2) constructor injection
	 * 
	 * @return
	 */
	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	//@Scope(scopeName = "prototype")
	// by default, a bean is singleton (bean scopes: singleton, prototype)
	// Singleton scope: stateless app components (dao, service, controllers)
	// Prototype scope: stateful beans (objs, domain obj, app state)
	// Request scope (http request), Session scope (HttpSession)
	public Person person() {
		Person person = new Person(); 
		// Person person = new Person( utensil() ); // constructor injection 
		// setter injection
		person.setUtensil( utensil() );
		/*
		 * person.setBrain( brain() ); person.setHeart( heart() );
		 */
		return person;
	}
	
	@Bean
	public WritingUtensil utensil() {
		return new Pencil();
		//return new Crayon();
	}
	
}









