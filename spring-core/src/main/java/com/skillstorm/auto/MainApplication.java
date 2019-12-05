package com.skillstorm.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.skillstorm.auto") // no need for @Bean
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(MainApplication.class);
		// my controller
		System.out.println(context.getBean(MyController.class));
		// my service
		System.out.println(context.getBean(MyService.class));
		// my controller's service obj
		System.out.println(context.getBean(MyController.class).getService());
	}
	
}
