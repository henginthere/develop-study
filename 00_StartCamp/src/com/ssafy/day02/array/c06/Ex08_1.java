package com.ssafy.day02.array.c06;

public class Ex08_1 {
	public static void main(String[] args) {

		int[] intArray = { 3, 27, 13, 8, 235, 7, 22, 9, 435, 31, 54 };
		
		int min = 999;	// 충분히 큰 수
		int max = 0;	// 충분히 작은 수
		
		for (int i = 0; i < intArray.length; i++) {
			if( intArray[i] < min ) {
				min = intArray[i];
			}
			if( intArray[i] > max ) {
				max = intArray[i];
			}
		}
		
		System.out.println("Min : " + min + " Max : " + max);			
	}
}
