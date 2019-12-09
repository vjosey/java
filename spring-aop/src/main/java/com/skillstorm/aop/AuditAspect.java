package com.skillstorm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

	// pointcut expression.. * === 1 and only 1, .. === 0 or more
	@Before(value = "hookMethod()")
	// joinpoint that was intercepted can be injected here.
	public void auditSomethingBefore(JoinPoint joinPoint) {
		System.out.println("[@Before]: " + joinPoint.getSignature());
	}
	// "after finally"
	@After(value = "hookMethod()")
	public void auditSomethingAfter() {
		System.out.println("[@After]");
	}
	
	// occurs after an exception is thrown
	@AfterThrowing(pointcut = "hookMethod()", throwing = "e")
	public void logException(Exception e) {
		System.out.println("[@AfterThrowing]");
	}
	
	// occurs after the method successfully returns a value
	@AfterReturning(pointcut = "hookMethod()", returning = "var")
	public void logReturn(Object var) {
		System.out.println("[@AfterReturning]");
	}
	
	// Inject ProceedingJoinPoint (lets us proceed with execution)
	@Around(value = "hookMethod()")
	public Object around(ProceedingJoinPoint joinPoint) {
		// BEFORE
		System.out.println("@Around (before)");
		// hold whatever the advised method would be returning
		Object returnValue = null;
		try {
			// tell method to resume execution (PJP)
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("Exception caught in @Around");
		}
		// AFTER
		System.out.println("@Around (after)");
		return returnValue;
	}
	
	//@Pointcut("execution(public void doSomething(*, *))") // takes 2 args (of any type)
	@Pointcut("execution(public void doSomething())")
	// @Pointcut("execution(* doSomething(..))")
	// @Pointcut("execution(* doSome*(..))")
	// @Pointcut("execution(* do*(..))")
	// @Pointcut("execution(* *(..))") // everything... (almost never do this)
	// @Pointcut("within(com.skillstorm.service.StuffService)") // every method within class
	//@Pointcut("within(com.skillstorm.service.*)") // every method within a package
	public void hookMethod() {}
	
}






