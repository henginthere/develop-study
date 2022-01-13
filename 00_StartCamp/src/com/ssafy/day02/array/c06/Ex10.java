package com.ssafy.day02.array.c06;

public class Ex10 {
	public static void main(String[] args) {

		int[] intArray = { 
			1, 3, 4, 7, 8, 10, 12, 15, 16, 17, 18 
		};
		
		int[] used = new int[21];	// 0 : dummy

		for (int i = 0; i < intArray.length; i++) {
			used[intArray[i]]++;
		}
		
		for (int i = 1; i < used.length; i++) {
			if( used[i] == 0 ) {
				System.out.print(i + " ");
			}
		}			
	}
}
