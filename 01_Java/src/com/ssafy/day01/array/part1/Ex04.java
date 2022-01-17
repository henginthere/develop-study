package com.ssafy.day01.array.part1;

import java.util.Arrays;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		
		int N = 6;
        Random rand = new Random();
        // TODO: Ex02_1 문제를 for-each 문장으로 변경해보세요.
        int[] arr = new int[5];
        
        for (int i=0; i<arr.length;i++) {
        	arr[i]=rand.nextInt(N)+1;
        	
        }
        
        //System.out.println(Arrays.toString(arr));
        
        for (int x:arr) {
        	System.out.println(x);
        }
        // END:
	}
}
