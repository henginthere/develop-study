package com.ssafy.day02.basic.c04;

public class Ex18 {
	public static void main(String[] args) {
		int N = 6;
		
		// Math.random()
		System.out.printf( "%3d", (int) (Math.random()*N) + 1 );
		
		// java.util.Random
		java.util.Random generator = new java.util.Random();
		System.out.printf( "%3d", generator.nextInt(N) + 1 );
		
		// %
		System.out.printf( "%3d", ( (int) (Math.random()*100) % N ) + 1 );
	}
}
