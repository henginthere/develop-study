package com.ssafy.day04.ex09;

import java.util.ArrayList;

public class MainData2 extends MainData {
	private ArrayList<String> store = new ArrayList<String>();

	@Override
	synchronized public void increase(String name) {
		System.out.print(name + "가 " );
		int n = (int)(Math.random() * 100);
		store.add("Shoes" + n);
		this.notify();
		System.out.println("Shoes"+ n +" 입고");
	}

	@Override
	synchronized public void decrease(String name) {
		if (store.size() == 0) {
			try {
				System.out.println(name + " 대기중...");
				this.wait();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		String shoes = store.get(store.size() - 1);
		store.remove(store.size() - 1);
		System.out.println(name+"가 " + shoes + " 구매");
	}
}