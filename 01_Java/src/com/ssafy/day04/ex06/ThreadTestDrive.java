package com.ssafy.day04.ex06;

// Thread 구현 1
// Thread 구현 1: 1. java.lang.Thread 클래스를 상속받은 클래스를 하나 선언
class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name);
	}
	
	// Thread 구현 1: 2. java.lang.Thread 클래스의 run() 메서드 Overriding 하여 재정의
	@Override
	public void run() {
		int index = 0;
		while(true) {
			System.out.println(Thread.currentThread().getName() + " : " + index++);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (index == 10) {
				break;
			}
		}
	}
}

// Thread 구현 2
// Thread 구현 2: 1. 다른 클래스를 상속받고 있어 java.lang.Thread 클래스를 상속받지 못하는 경우인지 확인
// Thread 구현 2: 2. 1번 확인이 됐다면, Runnable 인터페이스를 상속받은 클래스를 하나 선언
class MyRunnable implements Runnable {

	// Thread 구현 2: 3. Runnable 인터페이스의 run() 메서드 재정의
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

public class ThreadTestDrive {

	public static void main(String[] args) {
		
		System.out.println("main 시작 ......");
		
		// Thread 구현 1: 3. 1번에서 선언한 클래스의 객체를 main() 메서드에 생성
		MyThread thread = new MyThread("One");
		// Thread 구현 1: 4. 3번에서 생성한 객체의 start() 메서드 호출
		thread.start();
		
		// Thread 구현 2: 4. 2번에서 선언한 클래스로 Runnable 객체를 main() 메서드에 생성
		MyRunnable runnable = new MyRunnable();
		
		// Thread 구현 2: 5. 4번에서 생성한 Runnable 객체를 가지고 java.lang.Thread 클래스의 객체 생성 (생성자 argumen에 주입)
		Thread thread2 = new Thread(runnable);
		
		// Thread 구현 2: 6. 5번에서 생성한 java.lang.Thread 객체의 start() 메서드 호출
		thread2.start();
		
		System.out.println("main 종료 ......");
	}
}
