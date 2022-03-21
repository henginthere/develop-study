package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.ws.dto.Board;
import com.ssafy.ws.model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;

	/**
	 * <pre> / 또는 /index 요청이 get 방식으로 들어왔을 때 index 로 연결한다.</pre>
	 * 
	 * @return
	 */
	@GetMapping({"/", "/index" })
	public String showRoot() {
		return "index";
	}

	/**
	 * <pre>
	 * /error/404 요청이 get 방식으로 들어왔을 때 error/404로 연결한다.
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/error/404")
	public String showError404() {
		return "error/404";
	}
	
	/**
	 * <pre>/list를 get 방식으로 요청할 때 도서 정보를 보여준다.</pre>
	 * 아직 MVC의 model 영역을 완성하지 않았기 때문에 여러 개의 Board를 직접 생성해서 List 형태로 전달한다.
	 * 정보를 Model 객체에 저장 후 forward로 list를 호출한다.
	 * @return
	 */
	@GetMapping("/list")
	public String showList(Model model) {
		List<Board> boards = bService.search();
		model.addAttribute("boards", boards);
		return "list";
	}
	/**
	 * get 방식의 regist 요청이 오면 regist 페이지를 forward로 연결한다.
	 * @return
	 */
	@GetMapping("/regist")
	public String showRegistForm() {
		return "regist";
	}
	

	/**
	 * post 방식의 regist 요청이 오면 요청으로 전달된 board 객체를 그대로 regist_result에 연결한다.
	 * @param board
	 * @return
	 */
	@PostMapping("/regist")
	public String doRegist(@ModelAttribute Board board) {
		
		return "regist_result";
	}
	
	/**
	 * <pre>
	 * /error/commonerr 요청이 get 방식으로 들어왔을 때 error/commonerr로 연결한다.
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/error/commonerr")
	public String showError500() {
		return "error/commonerr";
	}

}
