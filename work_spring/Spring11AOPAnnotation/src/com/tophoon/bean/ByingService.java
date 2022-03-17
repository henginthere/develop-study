package com.tophoon.bean;

import org.springframework.stereotype.Component;

@Component("bying")
public class ByingService {
	public String sayGoodbye(String name, int age) {
		System.out.println("Good bye ..." + name + ", " + age);
		
		return "Return: Good bye";
	}
}
