package com.skillstorm.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.skillstorm.util.MyAwesomeBean;

//@EnableAutoConfiguration // auto configure defaults based on runtime
@ComponentScan(basePackages = "com.skillstorm.util") // componentscan
//@Configuration // bean config
@SpringBootApplication //=== these 3 ^^^
public class Application {
	
	@Autowired
	MyAwesomeBean bean;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
