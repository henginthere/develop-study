package com.ssafy.day01.array.part1;

import java.util.Arrays;

public class Ex02_2 {
	public static void main(String[] args) {
		
		String org = "SSAFY";
		
		// TODO: SSAFY를 char[]에 저장하고 출력하시오.
		
		// 1. char 배열을 org 변수에 담긴 문자열 길이만큼 생성하기 
		char[] str = new char[org.length()];
		// 2. org 변수에 담긴 String 문자열을 toCharArray 메서드를 이용하여 char 배열에 담기
		str=org.toCharArray();
		// 3. char 배열을 순서대로 출력하기 (Arrays 클래스의 toString 메서드 이용)
		System.out.println(Arrays.toString(str));
		// END:
	}
}
