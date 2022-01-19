package com.ssafy.day03.excep;

public class MyExceptionTestDrive {
	public static void main(String[] args) {
		int res = 0;
		MyExceptionTestDrive testDrive = new MyExceptionTestDrive();

		for (int i = 0; i < 4; i++) {
			try {
				res = testDrive.calc(2, i);
				System.out.println(i + ") res = " + res);
			}
			catch(MyException e) {
				System.out.println(e);
				e.myMethod();
			}
		}
		System.out.println("End of main body");
	}

	private int calc(int x, int y) throws MyException {
		if (x-y == 0) {
			//MyException me = new MyException();
			//throw me;
			throw new MyException();
		}
		int result = (x + y) / (x - y);
		return result;
	}
}

