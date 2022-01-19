package com.ssafy.day03.excep;

import java.util.Random;

public class MultiExceptionHandling2 {

	public static void main(String[] args) {
		try {
			int num = new Random().nextInt(2);
			System.out.println("code 1, num: " + num);
			
			String greetings[] = {"Good Bye"};
			System.out.println("code 2, greetings: " + greetings[num]);
			
			int i = 1 / num;
			System.out.println("code 3, i: " + i);
		}
		catch (Exception e) {
			System.out.println("나머지 모든 예외처리");
		}
		/*catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 예외처리");
		}
		catch (ArithmeticException e) {
			System.out.println("ArithmeticException 예외처리");
		}*/
	}
}
