package com.java.first;

import java.util.Scanner;

public class Compute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 개의 정수를 입력하세요 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int mul = a*b;
		int mok = a/b;
		System.out.println("곱 = "+mul);
		System.out.println("몫 = "+mok);
		sc.close();
	}
}
