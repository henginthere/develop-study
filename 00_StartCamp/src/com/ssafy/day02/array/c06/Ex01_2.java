package com.ssafy.day02.array.c06;

public class Ex01_2 {
	public static void main(String[] args) {

		int N = 6;

		int [] resultArray = new int[5];
		resultArray[0] = (int)(Math.random()*N) + 1;
		resultArray[1] = (int)(Math.random()*N) + 1;
		resultArray[2] = (int)(Math.random()*N) + 1;
		resultArray[3] = (int)(Math.random()*N) + 1;
		resultArray[4] = (int)(Math.random()*N) + 1;

		System.out.println(resultArray[0]);
		System.out.println(resultArray[1]);
		System.out.println(resultArray[2]);
		System.out.println(resultArray[3]);
		System.out.println(resultArray[4]);

	}
}
