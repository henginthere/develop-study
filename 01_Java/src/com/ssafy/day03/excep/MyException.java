package com.ssafy.day03.excep;

public class MyException extends Exception
{
	public MyException() {
		super("같은 값을 가질 수 없습니다.");
	}

	public void myMethod() {
		System.out.println("Exception 처리 문들...");
	}
}


