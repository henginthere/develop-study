package com.tophoon.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.tophoon.bean.GreetingService;

public class TestDrive {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("/com/tophoon/config/config.xml");

		GreetingService service = context.getBean("greeting", GreetingService.class);
		service.sayHello();

		GreetingService service2 = context.getBean("greetingByXml", GreetingService.class);
		service2.sayHello();
	}
}
