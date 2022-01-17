package com.ssafy.day01.array.part1;

public class Ex08_1 {
	public static void main(String[] args) {

		int[] intArray = { 3, 27, 13, 8, 235, 7, 22, 9, 435, 31, 54 };

	    int min = 999;
	    int max = -999;

	    // TODO: 위 배열의 요소 중 최대 값과 최소 값을 출력하시오.
	    for(int i=0;i<intArray.length;i++) {
	    	if(intArray[i]<min)
	    		min=intArray[i];
	    	if(intArray[i]>max)
	    		max=intArray[i];
	    }
	    // END:
	    System.out.printf("min: %d, max: %d%n", min, max);
	}
}
