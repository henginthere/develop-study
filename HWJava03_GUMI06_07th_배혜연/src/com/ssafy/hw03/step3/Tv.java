package com.ssafy.hw03.step3;

public class Tv extends Product{

	int inch;
	String type;
	
	public Tv(){}
	public Tv(String pNum, String name, int price, int cnt, int inch, String type){
		super(pNum, name, price, cnt);
		this.inch = inch;
		this.type = type;
	}
	
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString() {
		return this.pNum + "| " + this.name + "   |   "+this.price+"   |  "+this.cnt+"     |  "+this.inch+"   |   "+this.type;
		
	}
	
}
