package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepo repo;
	
	public BookRepo getRepo() {
		return repo;
	}

	//@Autowired
	public void setRepo(BookRepo repo) {
		this.repo = repo;
	}

	@Override
	public int insert(Book book) {
		this.repo.insert(book);
		return 0;
	}

	@Override
	public int update(Book book) {
		return repo.update(book);
	}

	@Override
	public int delete(String isbn) {
		return repo.delete(isbn);
	}

	@Override
	public Book select(String isbn) {
		return repo.select(isbn);
	}

	@Override
	public List<Book> search() {
		return repo.search();
	}

}
