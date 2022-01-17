package com.ssafy.day01.ex01.person;

public class Person {
	
	// 1. 사람의 속성(필드)을 작성하기
    String name;
    String gender;
    int age;
    
    // 2. 사람의 기능(메서드)을 작성하기
	void walk() {
		System.out.println(name+"이(가) 걷습니다.");
	}
	void order() {
		System.out.println(name+"이(가) 주문했습니다.");
	}
	void eat() {
		System.out.println(name+ "이(가) 식사합니다.");
	}
}
