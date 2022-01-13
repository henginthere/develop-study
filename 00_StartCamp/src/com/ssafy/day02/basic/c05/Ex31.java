package com.ssafy.day02.basic.c05;

public class Ex31 {
	public static void main(String[] args) {

		for( int i=0; i<5; i++ ) {
			
			for( int j=0; j<i; j++ ) {
				
				if( j==3 ) break;
				if( j==2 ) continue;
				
				System.out.println(j);
			}
		}
	}
}
