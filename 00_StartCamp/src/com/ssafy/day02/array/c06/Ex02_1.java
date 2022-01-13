package com.ssafy.day02.array.c06;

public class Ex02_1 {
	public static void main(String[] args) {
		String ssafyStr = "SSAFY";
		
		char[] ssafyArray = new char[ssafyStr.length()];
		
		for (int i = 0; i < ssafyArray.length; i++) {
			ssafyArray[i] = ssafyStr.charAt(i);
		}
		
		for (int i = 0; i < ssafyArray.length; i++) {
			System.out.print(ssafyArray[i]);
		}			
	}
}
