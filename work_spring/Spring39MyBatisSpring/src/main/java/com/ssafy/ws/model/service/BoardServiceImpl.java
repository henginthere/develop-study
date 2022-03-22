package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.Board;
import com.ssafy.ws.model.repo.BoardRepo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepo repo;
	
	public BoardRepo getRepo() {
		return repo;
	}

	// @Autowired
	public void setRepo(BoardRepo repo) {
		this.repo = repo;
	}

	@Override
	public int insert(Board board) {
		return repo.insert(board);
	}

	@Override
	public int update(Board board) {
		return repo.update(board);
	}

	@Override
	public int delete(String no) {
		return repo.delete(no);
	}

	@Override
	public Board select(String no) {
		return repo.select(no);
	}

	@Override
	public List<Board> search() {
		return repo.search();
	}

}
