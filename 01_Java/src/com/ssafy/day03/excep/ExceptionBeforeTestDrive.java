package com.ssafy.day03.excep;

public class ExceptionBeforeTestDrive {

	public static void main(String[] args) {
		ExceptionBeforeTestDrive testDrive = new ExceptionBeforeTestDrive();
		testDrive.printMessages();
		System.out.println("main End..이건 꼭 수행해야 하는데...");
	}

	private void printMessages() {
		int i = 0;
		String greetings[] = {"Good Bye", "Hi~", "안녕히~"};

		while (i < 4) {
			System.out.println(greetings[i]);
			i++;
		}

		System.out.println("Method End.." + i);
	}
}



