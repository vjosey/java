package com.skillstorm.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

	// pointcut expression.. * === 1 and only 1, .. === 0 or more
	@Before(value = "hookMethod()")
	public void auditSomethingBefore() {
		System.out.println("[@Before]");
	}
	
	@After(value = "hookMethod()")
	public void auditSomethingAfter() {
		System.out.println("[@After]");
	}
	
	// @Pointcut("execution(public void doSomething())")
	// @Pointcut("execution(* doSomething(..))")
	// @Pointcut("execution(* doSome*(..))")
	// @Pointcut("execution(* do*(..))")
	 @Pointcut("execution(* *(..))") // everything... (almost never do this)
	// @Pointcut("within(com.skillstorm.service.StuffService)") // every method within class
	//@Pointcut("within(com.skillstorm.service.*)") // every method within a package
	public void hookMethod() {}
	
}






