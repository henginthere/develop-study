package com.ssafy.board.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class ListBoardService implements BoardService {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String page = "./view/list.jsp";
		List<Board> list = new ArrayList<>();
		
		try {
			// DAO: Data Access Object (데이터베이스 SQL문을 실행하는 객체)
			BoardDao boardDao = new BoardDao();
			list = boardDao.list();
			req.setAttribute("list", list);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return page;
	}
}
