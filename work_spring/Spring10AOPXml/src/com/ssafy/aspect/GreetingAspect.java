package com.ssafy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;


public class GreetingAspect {
	
	public void start(JoinPoint point) {
		Signature signature = point.getSignature();
		String type = signature.getDeclaringTypeName();
		String name = signature.getName();
		Object[] args = point.getArgs();
		System.out.println(">> log start: "+type+", "+name+"()");
	}

	public void end() {
		System.out.println(">> log end");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println(">> around before");
		long start = System.nanoTime();
		
		Object[] args = pjp.getArgs();
		for(Object o:args) {
			System.out.println(">> around: "+o);
		}
		
		if(args!=null && args.length>0) {
			args[0]="kim";
			args[1]=37;
		}
		
		Object string = pjp.proceed(args); //실제 호출할 메소드
		
		long end = System.nanoTime();
		System.out.println(">> around after: "+(end-start)+"ns");
		
		return "Return: Aspect Good bye";
		
	}
	
	public void returning() {
		System.out.println(">> returning");
	}
	
	public void throwing() {
		System.out.println(">> throwing");
	}
}
