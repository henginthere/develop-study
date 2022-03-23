package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}) //어느 출처건 상관없이 API 사용 가능하게 허용해줌 (*) *자리에 주소넣어주면 그 주소만 허용해주는 것
@RestController
@RequestMapping("/bookapi")
@Api(value = "Book")
public class BookRestController {
	
	@Autowired
	private BookService bService;
	
	//Get/api/board 요청했을 때 실행 됨
	@ApiOperation(value="query string에 해당하는 검색 조건에 해당하는 도서 목록을 반환한다.", response = List.class)
	@GetMapping("/book")
	public ResponseEntity<?> searchBook(){  // ? : 와일드카드, return 할 때 return 타입 결정된다
		List<Book> boards = bService.search(); //전체 책을 가져온다
		
		if(boards != null && !boards.isEmpty()) { //null이 아니고 비어있지 않으면 데이터가 들어가있는 것
			return new ResponseEntity<List<Book>>(boards, HttpStatus.OK); //ResponseEntity 객체 만들어서 return. 자바 객체를 JSON 문자열로 바꿔주는 역할을 한다
			//이후 client에 응답
			//HttpStatus.OK : 상태전달 -> OK 코드는 200
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		//HttpStatus.NO_CONTENT : 204
	}
	
	@ApiOperation(value="{isbn}에 해당하는 도서 정보를 반환한다.", response = List.class)
	@GetMapping("/book/{isbn}")
	public ResponseEntity<?> selectBook(@PathVariable("isbn") String isbn) {
		Book book = bService.select(isbn);
		
		if (book != null) {
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="Book 객체를 저장한다.", response = List.class)
	@PostMapping("/book")
	public ResponseEntity<?> insertBook(@RequestBody Book book) {
		int result = bService.insert(book);
		
		if (result > 0) {
			return new ResponseEntity<Book>(book, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="Book 객체를 수정한다.", response = List.class)
	@PutMapping("/book/{isbn}")
	public ResponseEntity<?> updateBook(@PathVariable("isbn") String isbn, @RequestBody Book book) {
		book.setIsbn(isbn);
		int result = bService.update(book);
		
		if (result > 0) {
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="Book 객체를 삭제한다.", response = List.class)
	@DeleteMapping("/book/{isbn}")
	public ResponseEntity<?> deleteBook(@PathVariable("isbn") String isbn) {
		int result = bService.delete(isbn);
		
		if (result > 0) {
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
