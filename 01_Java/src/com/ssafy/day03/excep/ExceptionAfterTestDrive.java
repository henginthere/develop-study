package com.ssafy.day03.excep;

public class ExceptionAfterTestDrive {

	public static void main(String[] args) {
		ExceptionAfterTestDrive testDrive = new ExceptionAfterTestDrive();
		testDrive.printMessages();
		System.out.println("main End..이건 꼭 수행해야 하는데...");
	}

	private void printMessages() {
		int i = 0;
		String greetings[] = {"Good Bye", "Hi~", "안녕히~"};
		try {
			while (i < 4) {
				System.out.println(greetings[i]);
				i++;
			}
		}
		catch(Exception e) {
			System.out.println("Error :" + e);
			System.out.println("배열 크기 확인 필요: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Method End.." + i);
	}
}


