package com.ssafy.day02.basic.c05;

public class Ex26_2 {
	public static void main(String[] args) {

		int N = 6;
		
		int result = (int) (Math.random()*N) + 1;
		System.out.println(result);
		boolean isEven = ( result % 2 == 0 ) ? true : false;
		
		result = (int) (Math.random()*N) + 1;
		System.out.println(result);
		boolean isSame = ( ( result % 2 == 0 ) == isEven ) ? true : false;
		
		if( isSame ) {
			System.out.println("A");
		}else {
			System.out.println("B");
		}
	}
}
