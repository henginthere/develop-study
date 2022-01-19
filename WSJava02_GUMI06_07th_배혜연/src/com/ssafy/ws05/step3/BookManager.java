package com.ssafy.ws05.step3;

import com.ssafy.ws05.step3.Book;
import com.ssafy.ws05.step3.Magazine;

public class BookManager {

	
	int MAX_SIZE=100; //도서정보는 최대 100권을 넘지 않는다.
	int size=0;
	
	Book[] books = new Book[MAX_SIZE];

	public BookManager(){
		
	}
	
	public void add(Book book) {
		
		books[size++]=book;		
	}
	
	public void remove(String isbn) {
		
		Book[] result = new Book[size];
		int resultIndex=-1;
		for(int i=0;i<books.length;i++) {
			if(books[i].getIsbn().equals(isbn)) {
				continue;
			}
			result[++resultIndex]=books[i];
		}
		this.books = result;
		this.size = resultIndex;
	}
	
	public Book[] getList() {
	
		Book[] temp=new Book[size];
		
		for(int i=0;i<size;i++) {
			if(books[i]!=null) {
			temp[i]=books[i];
			}
		}
		return temp;
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return(books[i]);
			}
		} return null;
	}
	
	public Book[] searchByTitle(String title) {
		int count=0; 
		Book[] temp = new Book[size];
		for(int i=0;i<size;i++) { 
			if(books[i].getTitle().contains(title)) {
				temp[count++] = books[i];
				}
			}
		Book[] result = new Book[count];
		for(int i=0;i<count;i++)
			result[i]=temp[i];
		return result; 
	}
	
	public Book[] getBooks() {
		int count=0;
		Book[] temp = new Book[size];
		for(int i=0;i<size;i++) {
			if(!(books[i] instanceof Magazine)) { //magazine이 아닌 객체를 가져와야 일반책 객체만 가져올 수 있음(magazine은 book이면서 magazine이기때문)
				temp[count++]=books[i];
			}
		}
		Book[] result = new Book[count];
		for(int i=0;i<count;i++) {
			result[i]=temp[i];
		}
		return result;
	}
	
	public Book[] getMegazines() {
		int count=0;
		Book[] temp = new Book[size];
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine) {
				temp[count++]=books[i];
			}
		}	
		Book[] result = new Book[count];
		for(int i=0;i<count;i++) {
			result[i]=temp[i];
		}
		return result;
		
	}
	
	public int getTotalPrice() {
		int sum=0; 
		for(int i=0;i<size;i++) {
			sum+=(books[i].getPrice());
		}
		return sum;
	}

	public double getPriceAvg() {
		double avg = getTotalPrice()/size;
		return avg;
	}
	

}
