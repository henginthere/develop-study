package com.ssafy.day04.ex09;

public class MainData {
	private int data;

	public synchronized void increase(String name) {
		System.out.print(name + "가 " + data);
		data++;
		this.notify(); //wait 상태의 thread들이 runnable 상태가 됨
		System.out.println("를 " + data + "로 증가시킴");
	}

	public synchronized void decrease(String name) {
		if (data <= 0) {
			try {
				System.out.println(name + " 대기중...");
				this.wait(); //data가 0이하가 되면 thread wait 상태가 됨
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.print(name + "가 " + data);
		data--;
		System.out.println("를 " + data + "로 감소시킴");
	}
}