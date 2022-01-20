package com.ssafy.ws04.step3;

import com.ssafy.ws04.step3.Book;
import com.ssafy.ws04.step3.Magazine;
import com.ssafy.ws04.step3.BookManagerImpl;

public class BookTest {

	public static void main(String[] args) {
		
		//객체 생성시 파일 불러오기
		BookManagerImpl bm = BookManagerImpl.getInstance();
		
		Book book1 = new Book("21424", "Java Pro", "김하나", "jean.kr",15000, "Java 기본문법",5);
		Book book2 = new Book("21425", "Java Pro2", "김하나", "jean.kr",25000, "Java 응용",10);
		Book book3 = new Book("35355", "분석설계", "소나무", "jean.kr",30000, "SW 모델링",2);
		Magazine magazine1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jean.kr",10000, "1월 알고리즘", 3, 2021, 1);
		
		//도서 추가
		bm.add(book1);
		bm.add(book2);
		bm.add(book3);
		bm.add(magazine1);
	
		//파일에 도서 저장
		bm.saveData();
		
		
		//bm.loadData();
			
				
	}
}
