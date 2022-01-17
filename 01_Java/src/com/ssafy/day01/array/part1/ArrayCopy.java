package com.ssafy.day01.array.part1;

import java.util.Arrays;

public class ArrayCopy {
	
	public static void main(String[] args) {

		int[] srcArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] tgtArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		/*
		 * arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		 * src: 원본 배열 객체
		 * srcPos: 원본 배열에서 복사를 시작할 위치의 인덱스 번호
		 * dest: 사본 배열 객체
		 * destPos: 사본 배열에서 붙여넣기를 시작할 위치의 인덱스 번호
		 * length: 원본 배열 srcPos부터 복사할 길이
		 */
		System.arraycopy(srcArray, 2, tgtArray, 1, 3);
		
		System.out.println(Arrays.toString(tgtArray));
	}

}
