package com.ssafy.hw04.step3;

import com.ssafy.hw04.step3.Tv;
import com.ssafy.hw04.step3.Refrigerator;
import java.io.Serializable;

public class Product implements Serializable{

	String pNum;
	String name;
	int price;
	int cnt;
	
	Product() {}
	public Product(String pNum, String name, int price, int cnt){
		this.pNum = pNum;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
