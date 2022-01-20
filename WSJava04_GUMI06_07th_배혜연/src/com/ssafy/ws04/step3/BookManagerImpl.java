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
	
	//book.dat 파일에서 도서리스트 읽어오는 메서드
	private void loadData() {
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("book.dat");
			ois = new ObjectInputStream(fis);

			ArrayList<Object> tmp = new ArrayList<>();
		
			tmp=(ArrayList<Object>) ois.readObject();

			System.out.println("****************************불러온 도서 전체 목록****************************");
			for(Object o:tmp) {
				System.out.println(o);
			}
		
		}
		catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("****************************불러온 도서 전체 목록****************************");
			System.out.println("등록된 도서가 없습니다.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (NullPointerException e) {
				
			}
		}
	}
	

	//book.dat 파일에 도서리스트 저장 메서드
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
		//System.out.println("객체 정보를 파일에 저장 완료.");
	}
}
