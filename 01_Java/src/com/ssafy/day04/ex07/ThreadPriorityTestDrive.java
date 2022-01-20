package com.ssafy.day04.ex07;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		int index = 0;
		while(true) {
			System.out.println(Thread.currentThread().getName() + " : " + index++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (index == 10) {
				break;
			}
		}
	}
	
}

public class ThreadPriorityTestDrive {
	
	public static void main(String[] args) {
		Runnable r1 = new MyRunnable();
		Runnable r2 = new MyRunnable();
		Runnable r3 = new MyRunnable();
		
		Thread t1 = new Thread(r1, "One");
		Thread t2 = new Thread(r2, "Two");
		Thread t3 = new Thread(r3, "Three");
		
		t1.setPriority(Thread.MAX_PRIORITY);  // 10
		t2.setPriority(Thread.NORM_PRIORITY);  // 5
		t3.setPriority(Thread.MIN_PRIORITY);  // 1
		
		t1.start();
		t2.start();
		t3.start();
	}
}
