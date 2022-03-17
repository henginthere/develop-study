package com.ssafy.bean;

public class Person implements IPerson{
	
	private String greeting = "안녕하세요?";
	private String name = "현빈";
	private int age = 36;
	
	public Person() {
		System.out.println("기본 생성자 호출...");	
	}
	
	public Person(String greeting) {
		this.greeting = greeting;
	}
	
	public Person(int age) {
		this.age = age;
	}
	
	public Person(String greeting, String name, int age) {
		this.greeting = greeting;
		this.name = name;
		this.age = age;
	}

	@Override
	public void sayHello() {
		System.out.println(name+"("+age+")"+" : "+greeting);
	}
	
}
