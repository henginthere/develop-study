package com.ssafy.ws07.step3;

import java.util.ArrayList;
import java.util.Scanner;

import com.ssafy.ws07.step3.Book;

public class BookManagerImpl implements IBookManager{
//	//2. 생성한 객체를 저장할 instance private field 선언
//	private BookManagerImpl instance; 
//	//1. 외부에서 객체 생성을 못하도록 막아야 된다.(생성자)
//	private BookManagerImpl(){ //private 접근제한
//	}
//	//3. 외부에서 IBookManagerImpl가 가지고 있는 매니저 객체를 리턴해줄 메서드 작성
//	public static BookManagerImpl getInstance() {
//		return new BookManagerImpl();
//	}
	
	Book book = new Book();
	private ArrayList<Book> books = new ArrayList<Book>();
	Scanner sc = new Scanner(System.in);
	
	public void add(Book book) {
		int cnt=0;
		System.out.println("도서등록");
		System.out.print("등록할 도서의 고유번호를 입력하세요.");
		String tmp = sc.next();
		
		for(int i=0;i<books.size();i++) {
			if(tmp.equals(books.get(i).getIsbn())){
				cnt++;
				System.out.println("이미 등록된 도서입니다.");
				break;
			}
		}
		if(cnt==0) {
			book.setIsbn(tmp);
		}
		
		System.out.println("등록가능.");
		System.out.println("등록할 도서의 제목, 작가, 출판사, 가격, 간단설명을 입력하세요.");
		System.out.print("제목 : ");
		book.setTitle(sc.next());
		System.out.print("작가 : ");
		book.setAuthor(sc.next());
		System.out.print("출판사 : ");
		book.setPublisher(sc.next());
		System.out.print("가격 : ");
		book.setPrice(sc.nextInt());
		System.out.print("간단설명 : ");
		book.setDesc(sc.next());
		
		books.add(book);
		System.out.println("등록완료.");
	}
	public void remove(String isbn) {
		
		System.out.println("도서삭제");
		System.out.print("삭제할 도서의 고유번호를 입력하세요: ");
		String tmp=sc.next();
		
		int cnt = 0;
        for (int i = 0; i < books.size(); i++) {
            if (tmp.equals(books.get(i).getIsbn())) {
                books.remove(i);
                cnt++;
                System.out.println("도서 삭제 완료");
                break;
            }
        } 
        if (cnt == 0) {
            System.out.println("해당 도서가 존재하지 않습니다.");
        } 
	}
	public Book[] getList() {
		Book[] temp = new Book[100];
		int i = 0;
		for(Book b : books) {
			if(b == null) {
				continue;
			}
			else if(b.equals(books.get(i))) {
				temp[i] = b;
			}
			i++;
		}
		return temp;
	}
	public Book searchByIsbn(String isbn) {
		Book temp = null;
		for(Book b : books) {
			if(b != null) {
				if(b.getIsbn().equals(isbn)) {
					temp = b;
				}
			}
		}
		return temp;
	}
	public Book[] searchByTitle(String title) {
		Book[] temp = new Book[100];
		int i=0;
		int cnt=0;
		for(Book b : books) {
			if(b != null) {
				if(b.getTitle().contains(title)) {
					temp[i++] = b;
					cnt++;
				}
			}
		}
		Book[] fin = new Book[cnt];
		for(int j=0;j<cnt;j++) {
			if(temp[j]!=null) {
				fin[j]=temp[j];
			}
		}
		return fin;
	}
//	public Magazine[] getMagazines() {
//		Magazine[] temp = new Magazine[100];
//		int i = 0;
//		for(Book b : books) {
//			if(b == null) {
//				continue;
//			}
//			else if(b.getYear()) {
//				temp[i] = b;
//			}
//			i++;
//		}
//		return temp;
//	}
//	Book[] getBooks();
//	int getTotalPrice();
//	double getPriceAvg();
//	void sell(String isbn, int quantity);
//	void buy(String isbn, int quantity);

}
