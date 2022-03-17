package com.ssafy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.bean.ByingService;
import com.ssafy.bean.GreetingService;

public class TestDrive {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new GenericXmlApplicationContext("/com/ssafy/config/config.xml");
		
		GreetingService service = context.getBean("greeting",GreetingService.class);
		service.sayHello();
		
		ByingService service2 = context.getBean("bying",ByingService.class);
		String string = service2.sayGoodbye("Jeong", 37);
		System.out.println(string);
	}
	


}
