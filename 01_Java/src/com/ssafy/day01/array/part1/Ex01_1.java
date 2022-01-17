package com.ssafy.day01.array.part1;

import java.util.Random;

public class Ex01_1 {
	public static void main(String[] args) {

		int N = 6;
        Random rand = new Random();
        
        // 1. 난수 5개 뽑기
        int result1 = rand.nextInt(N) + 1;
        int result2 = rand.nextInt(N) + 1;
        int result3 = rand.nextInt(N) + 1;
        int result4 = rand.nextInt(N) + 1;
        int result5 = rand.nextInt(N) + 1;

        // 2. 저장된 난수 출력하기
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
		
	}
}
