package com.ssafy.day02.ex02.encapsulation.p2;

import com.ssafy.day02.ex02.encapsulation.p1.Parent;

public class OtherPackageChildClass extends Parent {
	public void useMember() {
		this.publicVar = 10;
		this.protectVar = 10;
		// The field Parent.privVar is not visible
		//this.defaultVar = 10;
		// this.privVar = 10;
	}
}
