package com.ssafy.day01.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloSsafyServlet extends HttpServlet{

	// 클라이언트에서 GET 요청이 들어온 경우에 호출
	private static final long serialVersionUID = -4401332290258235074L; 
	
	//init
	@Override
	public void init() throws ServletException {
		System.out.println("init 호출 ...");
	}
	@Override
	public void destroy() {
		System.out.println("destroy 호출 ...");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출 ...");
		
		//응답메시지의 Content-Type 설정
		resp.setContentType("test/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet !!<br>");
		out.println("<h2>안녕 서블릿!</h2>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}

}
