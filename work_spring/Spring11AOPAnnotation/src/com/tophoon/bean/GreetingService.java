package com.tophoon.bean;

import org.springframework.stereotype.Component;

@Component("greeting")
public class GreetingService {
	public void sayHello() {
		System.out.println("hello world!");
	}
}
