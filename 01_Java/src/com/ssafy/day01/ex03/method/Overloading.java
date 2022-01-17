package com.ssafy.day01.ex03.method;

public class Overloading {
	
	// Method Overloading 적용 대상
	int add(int a, int b) {
		return a + b;
	}
	
	// argument 개수가 다른 경우
	int add(int a, int b, int c) {
		return a + b + c;
	}
	
	// argument의 데이터 타입이 다른 경우
	int add(int a, short b) {
		return a + b;
	}
	
	// argument의 개수와 데이터 타입이 다른 경우
	int add(int a, short b, short c) {
		return a + b + c;
	}
	
	int add(short a, short b, short c) {
		return a + b + c;
	}
	
	int minus(int a, int b) {
		return a-b;
	}
	
	int minus1(int a, int b, int c) {
		return a-b-c;
	}
	public static void main(String[] args) {
		//ctrl+1 첫번째 선택하면 지역변수 자동으로 만들어줌
		Overloading o = new Overloading();
		int result = o.minus(5, 2);
		System.out.println(result);
		
		result = o.minus1(6, 3, 1);
		System.out.println(result);
	}
	
}
