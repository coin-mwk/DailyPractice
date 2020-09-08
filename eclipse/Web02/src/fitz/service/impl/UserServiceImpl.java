package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {
		return userDao.queryUserByUsernameAndPassword(user.getUsername(),
				user.getPassword());
	}

	@Override
	public void registUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public boolean existsUsername(String username) {
		User user = userDao.queryUserByUsername(username);

		if (user != null) {
			// 用户名已存在
			return true;
		}
		// 用户名可用
		return false;
	}

}
