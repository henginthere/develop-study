package com.ssafy.ws.model.repo;

import java.util.List;

import com.ssafy.ws.dto.Board;

public interface BoardRepo {
	
	int insert(Board board);
	
	int update(Board board);
	
	int delete(String no);
	
	Board select(String no);
	
	List<Board> search();
}
