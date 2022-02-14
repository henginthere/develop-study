package com.ssafy.board.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.BoardService;
import com.ssafy.board.model.ListBoardService;

public class BoardServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6627330410471550698L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		
		// 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		// action 파라메터에 해당하는 값 가져오기
		String action = req.getParameter("action");
		
		// action에 따른 분기처리
		String page = null;
		BoardService service = null;
		
		switch (action) {
		case "list":
			service = new ListBoardService();
			page = service.execute(req, resp);
			break;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(page);
		try{
			rd.forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
