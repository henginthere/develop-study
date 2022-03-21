package com.ssafy.ws.model.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Book;

@Repository
public class BookRepoImpl implements BookRepo {
	
	public BookRepoImpl() {}

	@Override
	public int insert(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String isbn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book select(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> search() {
		
		List<Book> books = new ArrayList<>();
		books.add(new Book("111-222-3333","홍길동","첵제목1",10000,"좋은 책1", "abc1.png"));
		books.add(new Book("111-222-4444","임꺽정","첵제목2",20000,"좋은 책2", "abc2.png"));
		books.add(new Book("111-333-4444","장길산","첵제목3",30000,"좋은 책3", "abc3.png"));
		// TODO Auto-generated method stub
		return books;
	}
	
	
}
