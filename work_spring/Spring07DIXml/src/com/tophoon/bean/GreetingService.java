package com.tophoon.bean;

public class GreetingService {
	private IMessageDAO dao;
	
	public GreetingService() {}
	
	public GreetingService(IMessageDAO dao) {
		this.dao = dao;
	}
	
	public void setDao(IMessageDAO dao) {
		this.dao = dao;
	}
	
	public void sayHello() {
		System.out.println(dao.getMessage());
	}
}
