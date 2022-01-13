package com.ssafy.day02.basic.c05;

public class Ex33_1 {
	public static void main(String[] args) {

		for( int i=0; i<5; i++ ) {
			for( int j=0; j<5; j++ ) {
				if( j<=i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
