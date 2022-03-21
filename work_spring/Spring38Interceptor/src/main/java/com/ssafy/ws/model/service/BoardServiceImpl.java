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
		this.repo.insert(board);
		return 0;
	}

	@Override
	public int update(Board board) {
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
		return repo.search();
	}

}
