package com.ssafy.ws.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.service.BookService;

@Controller
public class BookController{
	@Autowired
	private BookService bService;

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
		List<Book> books = bService.search();
		model.addAttribute("books", books);
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
	public String doRegist(@ModelAttribute("book") Book book, Model model){
		bService.insert(book);
		model.addAttribute("book",book);
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
	
	@GetMapping("/book/{isbn}")
	public String bookDetail(@PathVariable String isbn, Model model) {
		Book book = bService.select(isbn);
		model.addAttribute("book",book);
		
		return "detail";
	}
	
	@RequestMapping(value="/modify/{isbn}", method = RequestMethod.GET)
	public String bookModify(@PathVariable String isbn, Model model) {
		Book book = bService.select(isbn);
		model.addAttribute("book",book);
		
		return "modify";
	}
	
//	@RequestMapping(value = "/modify", method = RequestMethod.POST)
//	public String bookModify(Book book) {
//		bService.update(book);
//		
//		return "redirect:/list";
//		
//	}
	@PostMapping("/modify")
	public String bookModify(@ModelAttribute("book") Book book){
		bService.update(book);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{no}")
	public String boardDelete(@PathVariable String no) {
		bService.delete(no);
		return "redirect:/list";
	}

}
