package com.ssafy.day02.array.c06;

public class Ex08_2 {
	public static void main(String[] args) {

		int[] intArray = { 3, 27, 13, 8, 235, 7, 22, 9, 435, 31, 54 };
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < intArray.length; i++) {
			min = Math.min(min, intArray[i]);
			max = Math.max(max, intArray[i]);
		}
		
		System.out.println("Min : " + min + " Max : " + max);			
    }
}
