package com.ssafy.day02.ex00;

import java.io.Serializable;

public class SmartDevice implements Serializable {

	static {
		System.out.println("메모리에 올라가면서 젤 먼저 실행...");
	}

	private String sn;
	private String devName;
	private String type;

	public SmartDevice() {

	}

	public SmartDevice(String sn, String devName, String type) {
		this.sn = sn;
		this.devName = devName;
		this.type = type;
	}

	public void call(String num) {
		System.out.println("전화걸기: " + num);
	}

	public void showDeviceInfo() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return getSn() + "\t|" + getDevName() + "\t|"  + getType();
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof SmartDevice)) {
			return false;
		}

		SmartDevice smartDevice = (SmartDevice) obj;
		boolean isEqualSn = this.getSn() == smartDevice.getSn();
		boolean isEqualName = this.getDevName() == smartDevice.getDevName();
		if (isEqualSn && isEqualName) {
			return true;
		}

		return false;
	}
}
