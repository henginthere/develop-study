package com.ssafy.day02.basic.c05;

public class Ex24 {
	public static void main(String[] args) {

		int num = 4;
		
		if( num == 3 & isEven(num) ) {
		//if( num == 3 && isEven(num) ) {
			System.out.println("3 !!");
		}
	}
	
	static boolean isEven(int num) {
		if( num % 2 == 0 ) {
			System.out.println("Even !!");
			return true;
		}else {
			return false;
		}
	}
}
