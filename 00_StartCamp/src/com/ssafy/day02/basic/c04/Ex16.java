package com.ssafy.day02.basic.c04;

public class Ex16 {
	public static void main(String[] args) {
		
		// bit and
		System.out.println("3 & 4 = " + (3 & 4));
		//   0011
		// & 0100
		// ------
		//   0000
		
		// bit or
		System.out.println("3 | 4 = " + (3 | 4));
		//   0011
		// | 0100
		// ------
		//   0111
		
		// bit exclusive
		System.out.println("3 ^ 4 = " + (3 ^ 4));
		//   0011
		// ^ 0100
		// ------
		//   0111
		
		// bit not
		System.out.println(" ~ 4 = " + (~ 4));
		//   0100
		// ~
		// ------
		//   1011
	}
}
