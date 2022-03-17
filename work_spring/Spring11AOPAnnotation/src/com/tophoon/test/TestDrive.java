package com.tophoon.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.tophoon.bean.ByingService;
import com.tophoon.bean.GreetingService;

public class TestDrive {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("/com/tophoon/config/config.xml");

		GreetingService service = context.getBean("greeting", GreetingService.class);
		System.out.println(service.getClass().getName());
		service.sayHello();

		ByingService service2 = context.getBean("bying", ByingService.class);
		String string = service2.sayGoodbye("Jeong", 32);
		System.out.println(string);
	}

}
