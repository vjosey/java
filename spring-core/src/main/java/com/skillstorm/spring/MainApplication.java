package com.skillstorm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillstorm.beans.Person;

public class MainApplication {

	public static void main(String[] args) {
		// start Spring Container with our Configuration class
		// BeanFactory. ApplicationContext (preinstaniate singleton beans)
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(HelloConfiguration.class);
		
		Person person = context.getBean(Person.class);
		person.write("Hello World");
		
		Person p = context.getBean(Person.class);
		System.out.println(person);
		System.out.println(p);
		
		// new ClassPathXmlApplicationContext();
		// new XmlWebApplicationContext();
		
	}
	
}
