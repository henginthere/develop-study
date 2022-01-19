package com.ssafy.hw.step3;

public class Refrigerator extends Product {

	
	int liter;
	Refrigerator(){	}
	
	public Refrigerator(String pNum, String name, int price, int cnt, int liter){
		
		super(pNum, name, price, cnt);
		this.liter = liter;
	}
	

	public int getLiter() {
		return liter;
	}
	public void setLiter(int liter) {
		this.liter = liter;
	}
	
	public String toString() {
		return this.pNum + "| " + this.name + "   |   "+this.price+"   |  "+this.cnt+"     |  "+this.liter;
		
	}
	
	
}
