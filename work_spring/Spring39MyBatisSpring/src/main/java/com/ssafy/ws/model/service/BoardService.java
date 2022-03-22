package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.dto.Board;

public interface BoardService {
	
	int insert(Board board);
	
	int update(Board board);
	
	int delete(String no);
	
	Board select(String no);
	
	List<Board> search();
	
}
