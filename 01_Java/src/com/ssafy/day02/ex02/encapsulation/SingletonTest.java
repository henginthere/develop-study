package com.ssafy.day02.ex02.encapsulation;

class SingletonClass {
	//2. 객체를 저장할 변수(필드) 선언
	private static SingletonClass instance;
	
	//1. 생성자 외부호출 차단
	private SingletonClass() {} //기본생성자에서 private 해버리면 외부에서 객체 생성할 수 없어요
	
	//3. 외부에서 SingletonClass 객체 사용을 위한 메서드 구현
	public static SingletonClass getInstance() {
		if(instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}
	
	public void sayHello() {
		System.out.println("Hello");
	}
}

public class SingletonTest {
	public static void main(String[] args) {
		SingletonClass sc1 = SingletonClass.getInstance();
		SingletonClass sc2 = SingletonClass.getInstance();
		System.out.printf("두 객체는 같은가? %b%n", sc1==sc2);
		sc1.sayHello();
	}
}
