package com.ssafy.day02.basic.c05;

public class Ex26_3 {
	public static void main(String[] args) {

		int N = 6;
		
		int result1 = (int) (Math.random()*N) + 1;
		System.out.println(result1);
		
		int result2 = (int) (Math.random()*N) + 1;
		System.out.println(result2);
		
		if( ( result1 + result2 ) % 2 == 0 ) {
			System.out.println("A");
		}else {
			System.out.println("B");
		}
	}
}
