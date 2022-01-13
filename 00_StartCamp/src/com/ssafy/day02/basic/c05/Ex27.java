package com.ssafy.day02.basic.c05;

public class Ex27 {
	public static void main(String[] args) {

		int N = 6;
		
		float result = 0;
		
		for( int i=0; i<100; i++ ) {
			result += (int) (Math.random()*N) + 1;
		}
		
		System.out.println(result);
		System.out.println(result / 100);
	}
}
