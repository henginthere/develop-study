package com.ssafy.day01.array.part1;

import java.util.Random;

public class Ex01_2 {
	public static void main(String[] args) {

		int N = 6;
		Random rand = new Random();
		// TODO: 이전예제를 배열을 사용하는 형태로 변환하시오.
		int[] randomNum = new int[5];
		// 1. 난수 5개 뽑기 
		for (int i=0;i<5;i++) {
			randomNum[i]=rand.nextInt(N)+1;	
		}

		// 2. 저장된 난수 출력하기

		for(int i=0;i<5;i++) {
		System.out.println(randomNum[i]);
		// END:
		}
	}


}
