package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("키와 몸무게를 자연수로 입력하세요 (키, 몸무게 순): ");
		int height = sc.nextInt();
		int weight = sc.nextInt();
		int isFat = weight+100-height;
		
		System.out.println("당신의 비만수치는 "+isFat+"입니다.");
		if(isFat>0) {
			System.out.println("당신은 비만입니다.");
		}
	}
}
