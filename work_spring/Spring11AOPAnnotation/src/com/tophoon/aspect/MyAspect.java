package com.tophoon.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* say*(..))")
	public void pointCut(){}
	
	@Before("pointCut()")
	public void start() {
		System.out.println(">> start");
	}
	
	@After("pointCut()")
	public void end() {
		System.out.println(">> end");
	}
	
	@AfterReturning(pointcut="pointCut()", returning="string")
	public void returning(String string) {
		System.out.println(">> returning " + string);
	}
	
	@Around("pointCut()")
	public String around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(">> around-before: ");
		Object object = pjp.proceed();
		System.out.println(">> around-after: ");
		
		return object == null ? "null" : object.toString();
	}
	
	@AfterThrowing("pointCut()")
	public void throwing() {
		System.out.println(">> throwing");
	}
}
