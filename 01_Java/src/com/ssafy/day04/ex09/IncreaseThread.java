package com.ssafy.day04.ex09;

public class IncreaseThread extends Thread {
	private MainData mainData;

	public IncreaseThread(MainData mainData, String n) {
		super(n);	//Thread name
		this.mainData = mainData;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep((int)(Math.random() * 7000));
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			mainData.increase(this.getName());
		}
	}
}
