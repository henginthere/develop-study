package com.ssafy.backend.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.backend.dto.Book;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = -4141055509055795429L;

	// GET 요청에 호출되는 메서드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	// POST 요청에 호출되는 메서드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// POST 요청 시, 파라메터의 한글 값을 처리하기 위해 Encoding 설정
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	// GET, POST 요청 구분없이 호출되는 메서드
	private void process(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");
		
		// 클라이언트에서 요청한 action 값을 받아온다.
		String action = request.getParameter("action");

		// action 값에 해당하는 Controller 객체를 생성한다.
		switch (action) {
		
		// RegistService 객체를 생성 후, 도서 등록 비지니스 로직을 수행한다.  
		case "regist":
			regist(request);

			// JSP 화면 호출을 위해 RequestDsipatcher의 forward를 사용한다.
			// 이때 연결할 jsp의 이름을 넘겨준다. forward에서 /는 context-root를 나타낸다.
			RequestDispatcher rd = request.getRequestDispatcher("/regist_result.jsp");
			try {
				rd.forward(request, response);

			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void regist(HttpServletRequest request) {
		
		// 1. 클라이언트로 부터 전달받은 도서 정보를 변수에 담는다.
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("name");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
				
		
		// 2. 위에서 전달받은 도서 정보를 이용하여 Book 객체를 생성한다.
		Book book = new Book(isbn, title, author, price, desc);
		
		// 3. 생성한 Book 객체를 클라이언트로 응답하기 위해 book 이름의 속성을 생성하고 객체를 담는다.
//		book.setIsbn(isbn);
//		book.setTitle(title);
//		book.setAuthor(author);
//		book.setPrice(price);
//		book.setDesc(desc);
	}

}