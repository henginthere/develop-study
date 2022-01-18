package com.ssafy.day02.ex02.encapsulation;

class UnbelievableUserInfo {
	//이름은 null이 될 수 없음.
	public String name = "홍길동";
	
	// 계좌는 0보다 커야 함.
	public int account = 10000;
	
	// TODO: name 과 account에 부적절한 값이 할당되지 못하도록 처리하시오.
    // END:
}

public class UnbelievableTest {
	public static void main(String[] args) {
		UnbelievableUserInfo info = new UnbelievableUserInfo();
		System.out.printf("사용자 정보:%s, %d%n", info.name, info.account);
		info.name = null;
		info.account = -1000;
		System.out.printf("사용자 정보:%s, %d%n", info.name, info.account);
	}
}