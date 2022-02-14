package com.ssafy.board.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
	String execute(HttpServletRequest req, HttpServletResponse resp);
}
