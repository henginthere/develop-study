package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.User;
import com.ssafy.cafe.model.service.UserService;
import com.ssafy.cafe.model.service.UserServiceImpl;

public class UserDaoImpl implements UserDao{

	// Singleton Pattern 적용
		private static UserDao instance;
		private UserDaoImpl() {}
		
		public static UserDao getInstance() {
			if(instance==null) {
				instance = new UserDaoImpl();
			}
			return instance;
		}
		// End of Singleton Pattern 적용
	
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStamp(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User select(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
