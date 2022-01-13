package com.ssafy.day02.basic.c05;

public class Ex26_1 {
	public static void main(String[] args) {

		int N = 6;
		
		int result = (int) (Math.random()*N) + 1;
		System.out.println(result);
		boolean isEven = false;
		if ( result % 2 == 0 ) {
			isEven = true;
		}
		
		result = (int) (Math.random()*N) + 1;
		System.out.println(result);
		if ( result % 2 == 0 ) {
			if( isEven ) {
				System.out.println("A");
			}else {
				System.out.println("B");
			}
		}else if ( result % 2 == 1 ) {
			if( isEven ) {
				System.out.println("B");
			}else {
				System.out.println("A");
			}
		}
	}
}
