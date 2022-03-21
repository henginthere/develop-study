package com.ssafy.ws.model.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Board;

@Repository
public class BoardRepoImpl implements BoardRepo {
	
	public BoardRepoImpl() {}

	@Override
	public int insert(Board book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Board book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board select(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> search() {
		
		List<Board> books = new ArrayList<>();
		
		books.add(new Board(1, "글 제목-1", "글 내용-1", "글 작성자-1", new Date()));
		books.add(new Board(2, "글 제목-2", "글 내용-2", "글 작성자-2", new Date()));
		books.add(new Board(3, "글 제목-3", "글 내용-3", "글 작성자-3", new Date()));
		
		return books;
	}
	
	
}
