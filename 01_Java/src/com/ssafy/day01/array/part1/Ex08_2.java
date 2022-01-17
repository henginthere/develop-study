package com.ssafy.day01.array.part1;

public class Ex08_2 {
	public static void main(String[] args) {

		int[] intArray = {3, 27, 13, 8, 235, 7, 22, 9, 435, 31, 54};
	    
        // TODO: 문제 Ex08_1을 Integer와 Math class를 이용하여 re-factoring 해보세요.
		int min = Integer.MIN_VALUE;
	    int max = Integer.MAX_VALUE;
	    
	    for(int i=0;i<intArray.length;i++) {
	    	min=Math.min(min,intArray[i]);
	    	max=Math.max(intArray[i], max);
	    }
        // END:
        System.out.printf("min: %d, max: %d%n", min, max);

    }
}
