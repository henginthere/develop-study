package com.ssafy.day04.ex08;

class ThreadA extends Thread {
	
	@Override
	public void run() {
		System.out.println("스레드A 시작 ...");
		for (int i = 0; i <= 7; i++) {
			System.out.println("스레드A : " + i);
			try {
				sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadB extends Thread {
	
	ThreadA a; //B has a A
	
	public ThreadB(ThreadA a) { //Thread a 객체 넘겨 필드로 가지고있다.
		this.a = a;
	}
	
	@Override
	public void run() {
		System.out.println("스레드B 시작 ...");
		for (int i = 0; i <= 7; i++) {
			System.out.println("스레드B : " + i);
			try {
				if (i == 2) {
					a.join(); //a 먼저 실행, b 실행
					//a.join(5000);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadJoinTestDrive {
	
	public static void main(String[] args) {
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB(a);
		b.start();
		a.start();
	}
}
