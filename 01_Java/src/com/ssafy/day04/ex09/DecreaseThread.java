package com.ssafy.day04.ex09;

public class DecreaseThread extends Thread {
	private MainData mainData;

	public DecreaseThread(MainData mainData, String n) {
		super(n);
		this.mainData = mainData;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep((int)(Math.random() * 5000));
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			mainData.decrease(this.getName());
		}
	}
}
