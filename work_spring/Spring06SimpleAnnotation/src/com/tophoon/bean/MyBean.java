package com.tophoon.bean;

public class MyBean implements IMyBean {

	@Override
	public void sayHello() {
		System.out.println("hello spring annotation");
	}
}
