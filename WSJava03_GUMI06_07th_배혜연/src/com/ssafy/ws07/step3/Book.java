package com.ssafy.ws07.step3;

public class Book {

	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	int quantity;
	
	Book() {}
	Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity){
		this.isbn=isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity=quantity;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return this.isbn + "| " + this.title + "       | "+this.author+"   | "+this.publisher+"        | "+this.price+"  | "+this.desc
				+" |   "+this.quantity;
		
	}
	
	
}
