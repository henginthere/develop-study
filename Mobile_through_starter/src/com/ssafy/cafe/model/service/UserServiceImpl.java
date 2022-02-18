package com.ssafy.cafe.model.service;

import com.ssafy.cafe.model.dto.User;

public class UserServiceImpl implements UserService{

	// Singleton Pattern 적용
	private static UserService instance;
	private UserServiceImpl() {}
	
	public static UserService getInstance() {
		if(instance==null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	@Override
	public void join(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(String id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leave(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUsedId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
