package com.skillstorm.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.skillstorm.beans")
public class AutowireConfig {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AutowireConfig.class);
		context.getBean(Person.class).write("Aww.. BabyYoda");
	}
	
}
