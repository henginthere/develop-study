package com.ssafy.day02.basic.c05;

public class Ex32 {
	public static void main(String[] args) {

		int N = 6;

		int result = 0;
		int count = 0;

		while(true) {
			count++;
			result += (int)(Math.random()*N) + 1;
			if( result > 100 ) break;
		}

		System.out.println(count);
		System.out.println(result);
	}
}
