package com.ssafy.day04.ex03;

import java.util.Scanner;

// 키보드로부터 데이터 입력 3 (Java 5.0)
public class InputKeyboard3 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = s.next();
		
		System.out.print("나이 : ");
		int age = s.nextInt();
		
		System.out.println("이름은 " + name + " 입니다.");
		System.out.println("나이는 " + age + "세 입니다.");
	}
}
