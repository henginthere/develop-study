package com.ssafy.day02.ex02.encapsulation.p1;

public class SamePackageChildClass extends Parent {
	public void useMember() {
		this.publicVar = 10;
		this.protectVar = 10;
		this.defaultVar = 10;
		//The field Parent.privVar is not visible
		//this.privVar = 10;
	}
}