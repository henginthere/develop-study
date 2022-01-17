package com.java.first;

import java.util.Scanner;

public class CircleArea {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("원의 반지름 : ");
		int r = sc.nextInt();
		double r2 = r*r*3.14;
		System.out.println("반지름이 "+r+"cm인 원의 넓이는 "+r2+"㎠입니다.");
		sc.close();
}
	
}
