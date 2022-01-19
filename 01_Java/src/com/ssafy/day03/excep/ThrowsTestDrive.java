package com.ssafy.day03.excep;

import java.util.Random;

public class ThrowsTestDrive {

	public static void main(String[] args) {
		ThrowsTestDrive td = new ThrowsTestDrive();
		td.execute();
	}

	private void execute() {
		try {
			this.method1();
			this.method2();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 예외처리");
		}
		catch (ArithmeticException e) {
			System.out.println("ArithmeticException 예외처리");
		}
		catch (Exception e) {
			System.out.println("나머지 모든 예외처리");
		}
	}

	private void method1() throws ArrayIndexOutOfBoundsException {
		int num = new Random().nextInt(2);
		System.out.println("code 1, num: " + num);

		String greetings[] = {"Good Bye"};
		System.out.println("code 2, greetings: " + greetings[num]);
	}

	private void method2() throws ArithmeticException {
		int num = new Random().nextInt(2);
		System.out.println("code 3, num: " + num);

		int i = 1 / num;
		System.out.println("code 4, i: " + i);
	}

}
