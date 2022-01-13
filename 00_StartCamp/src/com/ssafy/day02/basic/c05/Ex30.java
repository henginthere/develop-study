package com.ssafy.day02.basic.c05;

public class Ex30 {
	public static void main(String[] args) {

		for( int i=0; i<2; i++ ) {
			
			for( int j=0; j<10; j++ ) {
				
				if( j==5 ) break;
				if( j==3 ) continue;
				
				System.out.println(j);
			}
		}
	}
}
