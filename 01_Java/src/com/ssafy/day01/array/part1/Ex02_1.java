package com.ssafy.day01.array.part1;

import java.io.StreamCorruptedException;

public class Ex02_1 {
	public static void main(String[] args) {
		
		String org = "SSAFY";
		
		// TODO: SSAFY를 char[]에 저장하고 출력하시오.
		
		// 1. char 배열을 org 변수에 담긴 문자열 길이만큼 생성하기 
		char[] str=new char[org.length()];
		// 2. org 변수에 담긴 문자 하나하나를 char 배열에 담기 (반복문 이용)
		for(int i=0;i<org.length();i++) {
			str[i]=org.charAt(i);
		}
		// 3. char 배열을 순서대로 출력하기 (반복문 이용)
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		// END:
	}
}
