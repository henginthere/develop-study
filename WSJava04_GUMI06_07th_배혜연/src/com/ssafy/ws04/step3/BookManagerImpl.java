package com.ssafy.ws04.step3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ssafy.ws04.step3.Book;
import com.ssafy.ws04.step3.Magazine;
import com.ssafy.ws04.step3.ISBNNotFoundException;
import com.ssafy.ws04.step3.myThread;

public class BookManagerImpl implements IBookManager{
	
	private static BookManagerImpl instance;
	
	private BookManagerImpl() {
		loadData();
	}
	
	public static BookManagerImpl getInstance() {
		if(instance==null) {
			instance = new BookManagerImpl();
		}
		return instance;
	}

	private ArrayList<Book> books = new ArrayList<>();

	@Override
	public void add(Book book) {
		books.add(book);
	}
	
	public void remove(String isbn) {
		
		for(Book b:books) {
			if(b.getIsbn().equals(isbn)) {
				books.remove(b);
			}
		}
	}
	
	public void clear() {	
			books.clear();
	}
	
	public ArrayList<Book> getList() {
	
		return books;
	}
	
	public Book searchByIsbn(String isbn) {
		
		Book temp = new Book();
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				temp = b;
			}
		}
		return temp;
	}

	
	public ArrayList<Book> searchByTitle(String title) {
		
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : books) {
			if(b.getTitle().contains(title)) {
				temp.add(b);
			}
		}
		return temp;
	}
	
	public ArrayList<Book> getBooks() {
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : books) {
			if(!(b instanceof Magazine)) {
				temp.add(b);
			}
		}
		return temp;
	}
	
	public ArrayList<Book> getMagazines() {
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : books) {
			if(b instanceof Magazine) {
				temp.add(b);
			}
		}
		return temp;
		
	}
	
	public int getTotalPrice() {
		int total = 0;
		for(Book b : books) {
			total += b.getPrice(); 
		}
		return total;
	}

	public double getPriceAvg() {
		double avg = getTotalPrice()/books.size();
		return avg;
	}
	
	public void sell(String isbn, int quantity) throws ISBNNotFoundException,QuantityException {
		
		boolean isIn=false;
		
		for(Book b:books) {
			if(b.getIsbn().equals(isbn)) {
				if(b.getQuantity()-quantity<0) {
					throw new QuantityException();
				}
				b.setQuantity(b.getQuantity()-quantity);
				isIn=true;
			}
		}
		if(isIn==false) {
			throw new ISBNNotFoundException();
		}
		
	}
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		
		boolean isIn=false;
		for(Book b:books) {
			if(b.getIsbn().equals(isbn)) {
				b.setQuantity(b.getQuantity()+quantity);
				isIn=true;
			}
		} 
		if(isIn==false) {
			throw new ISBNNotFoundException();
		}
	}
	
	//book.dat ???????????? ??????????????? ???????????? ?????????
	private void loadData() {
		
		myThread th = new myThread();
		Thread t = new Thread(th,"thread");
		
		t.start();
		
	}
	

	//book.dat ????????? ??????????????? ?????? ?????????
	public void saveData() {
		
		FileOutputStream fos = null;  //NS
		ObjectOutputStream oos = null; //PS
		try {
			fos = new FileOutputStream("book.dat");
			oos = new ObjectOutputStream(fos);

			
			oos.writeObject(books);
			oos.writeObject(null);
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("?????? ????????? ????????? ?????? ??????.");
	}
}
