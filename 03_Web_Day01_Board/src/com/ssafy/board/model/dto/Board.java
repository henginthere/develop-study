package com.ssafy.board.model.dto;

import java.sql.Timestamp;


//Java Bean
//DTO : Data Transfer Object (DB로부터 전달 된 데이터를 저장하여 운반하는 객체)
public class Board {

	private int no;
	private String title;
	private String content;
	private String writer;
	private Timestamp reqDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getReqDate() {
		return reqDate;
	}
	public void setReqDate(Timestamp reqDate) {
		this.reqDate = reqDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", reqDate=");
		builder.append(reqDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
