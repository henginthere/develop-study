package com.ssafy.day01.array.part1;

public class Ex10 {
	public static void main(String[] args) {

		int[] intArray = {1, 3, 4, 7, 8, 10, 12, 15, 16, 17, 18};
        int[] used = new int[21];
        // TODO: 1~20까지의 숫자 중 intArray에서 사용되지 않은 숫자를 출력하세요.
        for(int i=0;i<intArray.length;i++)
        	used[intArray[i]]++;
        for(int i=0;i<used.length;i++) {
        	if(used[i]==0) {
        		System.out.println(i);
        	}
        }
        // END:
	}
}
