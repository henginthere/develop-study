package com.ssafy.day01.array.part1;

import java.util.Arrays;

public class Ex09 {
	public static void main(String[] args) {

		int[] intArray = {3, 7, 2, 5, 7, 7, 9, 2, 8, 1, 1, 5, 3};
        int[] used = new int[10];
        // TODO: intArray에 사용된 요소가 각각 몇개씩인지 used에 저장하시오.
        for (int i=0;i<intArray.length;i++) {
        	used[intArray[i]]++;
        }
        // END:
        System.out.println(Arrays.toString(used));
	}
}
