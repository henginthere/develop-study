package com.ssafy.day02.array.c06;

import java.util.Arrays;

public class Ex02_2 {
	public static void main(String[] args) {

		String ssafyStr = "SSAFY";
		
		char[] ssafyArray = new char[ssafyStr.length()];
		
		for (int i = 0; i < ssafyArray.length; i++) {
			ssafyArray[i] = ssafyStr.charAt(i);
		}
		
		System.out.print(Arrays.toString(ssafyArray));		
	}
}
