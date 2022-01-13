package com.ssafy.day02.basic.c05;

public class Ex25 {
	public static void main(String[] args) {

		int N = 6;
		
		boolean isEven = ( N % 2 == 0 ) ? true : false;
		
		N = ( ! isEven ) ? 10 : 20;
		
		System.out.println(N);
	}
}
