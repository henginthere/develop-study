package com.ssafy.day04.q03;


class MyThread extends Thread{
	
	private Thread controlledthread;
	
	public MyThread(String threadName) {
		super(threadName); //super 클래스에 원하는 thread 이름 넣으면 thread 이름 설정 가능
	}
	
	public MyThread(String threadName, Thread controlledthread) {
		super(threadName);
		this.controlledthread=controlledthread;
		
	}
	@Override
	public void run() {
		System.out.println(this.getName()+"가 동작합니다."); //this.getName() == Thread.currentThread.getName()
		
		if(this.getName().equals("혜연이")) {
			methodA();
		}
		else if(this.getName().equals("혜연이2")) {
			methodB();
		}
	}
	
	void methodA() {
		//sleep 사용 방법
//		try {
//			Thread.sleep(1000); //threadA일 경우 sleep 걸어서 무조건 B가 먼저 실행되게 함 . Timed waiting 상태가 되는 것 뿐.
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		synchronized (this) { //this 자리에는 제어할 대상의 객체
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("methodA 실행");
		}
	}
	
	void methodB() {
		
		//threadB가 threadA 객체를 가지고 있어야됨
		synchronized (controlledthread) { //controlledthread에 threadA 객체 저장되어있음
		try {
			Thread.sleep(2000); //2. 그래서 A먼저 실행되게 해야해서 sleep 써야함
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		controlledthread.notify(); //1. methodA가 먼저 실행되고 wait 가 걸린 상태에서 notify를 실행해야 wait가 풀리는데 B가 먼저 실행되면 안된다...
		System.out.println("methodB 실행");
		}
	}
}
public class SimpleThreadExample {

	public static void main(String[] args) {
		//thread scheduler 마음대로 thread 호출하기 때문에 순서가 보장되지 않음. sleep을 걸어 조절 가능
		MyThread threadA = new MyThread("혜연이");
		MyThread threadB = new MyThread("혜연이2",threadA);
		
		threadA.start();
		threadB.start();
	}
	
}
