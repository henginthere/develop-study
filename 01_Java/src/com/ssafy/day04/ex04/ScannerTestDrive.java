package com.ssafy.day04.ex04;

import java.util.Scanner;

public class ScannerTestDrive {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputData = scanner.next();
		scanner.close();
		System.out.println(inputData);
	}
}
