package com.ssafy.ws05.step3;

import java.util.Scanner;

public class BookManager {

	
	int MAX_SIZE=100; //도서정보는 최대 100권을 넘지 않는다.
	int size=1;
	Book[] books = new Book[MAX_SIZE];
	boolean isRun = true;
	Scanner sc = new Scanner(System.in);
	BookManager(){}
	
	public void run() {
		while(isRun) {
			System.out.println("=======================================================================================================");
			System.out.println("1. 도서등록 | 2. 도서목록 | 3. 고유번호검색 | 4. 제목검색 | 5. 일반도서 | 6. 잡지  | 7. 도서리스트 가격/ 가격평균 | 8. 종료");
			System.out.println("=======================================================================================================");
			System.out.print("번호를 입력하세요 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				addBook();
				break;
			case 2:
				getList();
				break;
			case 3:
				searchByIsbn();
				break;
			case 4:
				searchByTitle();
				break;
			case 5:
				getBooks();
				break;
			case 6:
				getMegazines();
				break;
			case 7:
				getTotalprice();
				getPriceAvg();
				break;
			case 8:
				isRun = false;
				break;
			default:
				System.out.println("등록된 메뉴가 아닙니다.");
				
			}
		}
	}
	void add(Book book) {
		
		System.out.println("도서등록");
		System.out.println("등록할 도서의 고유번호, 제목, 작가, 출판사, 가격, 분류를 입력하세요.");
		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		String d = sc.next();
		int price = sc.nextInt();
		String e = sc.next();
		
		for(int i=0;i<books.length;i++) {
		if(books[i]==null) {
			size=i+1;
			books[i]=new Book(a,b,c,d,price,e);
			System.out.println("등록완료");
			break;
		}
		}
		
	}
	
	void remove(String isbn) {
		System.out.println("도서삭제");
		System.out.println("삭제할 도서의 고유번호를 입력하세요.");
		String bookNum = sc.next();
		Book b = findBook(bookNum);
		
		if(b==null) {
			System.out.println("입력하신 번호의 도서가 존재하지 않습니다.");
			return;
		}
		
		
		for(int i=0;i<books.length;i++) {
			if(books[i]!=null&&books[i].getIsbn()==bookNum) {
				books[i]=null;
				System.out.println("삭제완료");
				return;
			}
		}
	}
	
	public Book findBook(String isbn) {
		for(int i=0;i<books.length;i++) {
			if(books[i]!=null&&books[i].getIsbn()==isbn) {
				return books[i];
			}
		}
		return null;
	}
	
	
	
}
