package com.ssafy.ws07.step3;

public class ISBNNotFoundException extends Exception{

	public ISBNNotFoundException() {
		super("해당 번호의 도서가 존재하지 않습니다.");
	}
	
}
