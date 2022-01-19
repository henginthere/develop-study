package com.ssafy.ws07.step3;

public class Magazine extends Book{

	int year;
	int month;
	Magazine(){	}
	
	Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month, int quantity){
		
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	public String toString() {
		return super.isbn + "| " + super.title + "       | "
	+super.author+"   | "+super.publisher+"        | "	+super.price+"  | "+super.desc+
	"    | "+this.year+"   | "+this.month+"  |  "+super.quantity;
		
	}
	
	
}
