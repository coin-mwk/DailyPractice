package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {

	public User login(User user);

	public void registUser(User user);

	public boolean existsUsername(String username);

}

