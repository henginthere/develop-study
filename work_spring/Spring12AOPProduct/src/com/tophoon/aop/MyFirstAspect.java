package com.tophoon.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.tophoon.model.Product;

@Component
@Aspect
public class MyFirstAspect {

	@Before("execution(* findProduct())")
	public void before() {
		System.out.println("Hello Before");
	}

	@After("execution(* findProduct())")
	public void after() {
		System.out.println("Hello After");
	}

	@AfterReturning(value="execution(* findProduct())", returning="product")
	public void afterReturning(Product product) {
		System.out.println("Hello AfterReturning" + product);
	}

	@Around("execution(* findProduct())")
	public Product around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("Around before");
		Product p = (Product) point.proceed();
		System.out.println("Around after");

		return p;
	}

	@AfterThrowing(value="execution(* findProduct())", throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("Hello Throwing!");
	}

}
