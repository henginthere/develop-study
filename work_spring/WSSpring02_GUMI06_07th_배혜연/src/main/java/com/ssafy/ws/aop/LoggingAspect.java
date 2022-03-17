package com.ssafy.ws.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.*;
import org.aspectj.lang.ProceedingJoinPoint;


@Component
@Aspect
public class LoggingAspect {

	@Pointcut("execution(* com.ssafy.ws.model..*.*(..))")
	public void pointCut(){}
	
	@Before("pointCut()")
	public void start(JoinPoint joinPoint) {
		String string = joinPoint.getSignature().getName();
		System.out.println(string+" 메서드 호출");
		for(Object arg:joinPoint.getArgs()) {
			System.out.println(string+ " 아규먼트 "+ arg);
		}
	}
}
