package com.ssafy.day04.ex09;

public class SyncTestDrive {
	public static void main(String[] args) {
		MainData mainData = new MainData();
		//MainData mainData = new MainData2();

		IncreaseThread t1 = new IncreaseThread(mainData, "공급자 A");
		IncreaseThread t3 = new IncreaseThread(mainData, "공급자 B");

		DecreaseThread t2 = new DecreaseThread(mainData, "구매자 A");
		DecreaseThread t4 = new DecreaseThread(mainData, "구매자 B");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
