package com.ssafy.ws07.step3;

import com.ssafy.ws07.step3.Book;
import com.ssafy.ws07.step3.Magazine;
import com.ssafy.ws07.step3.BookManagerImpl;

public class BookTest {

	public static void main(String[] args) {
		
//		BookManagerImpl m1 = BookManagerImpl.getInstance();
//		BookManagerImpl m2 = BookManagerImpl.getInstance();
//		
//		if(m1==m2) {
//			System.out.println("성공");
//		}
//		else
//			System.out.println("실패");
		
		BookManagerImpl bm = BookManagerImpl.getInstance();
		
		Book book1 = new Book("21424", "Java Pro", "김하나", "jean.kr",15000, "Java 기본문법",5);
		Book book2 = new Book("21425", "Java Pro2", "김하나", "jean.kr",25000, "Java 응용",10);
		Book book3 = new Book("35355", "분석설계", "소나무", "jean.kr",30000, "SW 모델링",2);
		Magazine magazine1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jean.kr",10000, "1월 알고리즘",2021, 1, 3);
		
		//도서 추가
		bm.add(book1);
		bm.add(book2);
		bm.add(book3);
		bm.add(magazine1);
		
		//도서전체목록
		System.out.println("***************************도서 전체 목록***************************");
		for(Book b:bm.getList()) {
			System.out.println(b);
		}
		//일반도서목록
		System.out.println("***************************일반 도서 목록***************************");
		for(Book b:bm.getBooks()) {
			System.out.println(b);
		}
		
		//잡지목록
		System.out.println("***************************잡지 목록***************************");
		for(Book b:bm.getMagazines()) {
			System.out.println(b);
		}
		
		//도서 제목 포함 검색
		System.out.println("***************************도서 제목 포함 검색:Java***************************");
		for(Book b:bm.searchByTitle("Java")) {
			System.out.println(b);
		}
		
		
		//도서 가격 총합
		System.out.println("도서 가격 총합 : "+bm.getTotalPrice());
		//도서 가격 평균
		System.out.println("도서 가격 평균 : "+bm.getPriceAvg());
		
		//도서 판매
		System.out.println("***************************도서 판매: 21424, 10권***************************");
		try {
			bm.sell("21424",10 );
			System.out.println("***************************판매 결과***************************");
			bm.searchByIsbn("21424");
		}catch(ISBNNotFoundException e){
			System.out.println(e);
		}catch(QuantityException e) {
			System.out.println(e);
		}
		
		//도서 구매
		System.out.println("***************************도서 구매: 21424, 4권***************************");
		try {
			bm.buy("12424", 4);
			System.out.println("***************************구매 결과***************************");
			bm.searchByIsbn("12424");
		}catch(ISBNNotFoundException e){
			System.out.println(e);
		}
				
	}
}
