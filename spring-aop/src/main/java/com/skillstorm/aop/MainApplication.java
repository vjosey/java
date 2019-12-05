package com.skillstorm.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.skillstorm.service.StuffService;

@Configuration
@ComponentScan(basePackages = "com.skillstorm")
@EnableAspectJAutoProxy
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainApplication.class);
		StuffService service = (StuffService) context.getBean(StuffService.class);
		service.doSomething();
		service.doSomething(5);
		service.doSomething(10, "Hello ");
		service.doSomethingElse();
		service.doWork();
		service.stuff();
		// new StuffService().doSomething(); // only Spring beans are advised
		context.getBean(AnotherService.class).service();
	}

}
