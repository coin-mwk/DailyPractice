package com.atguigu.junit;

import org.junit.BeforeClass;
import org.junit.Test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

public class UserServiceTest {

	static UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userService = new UserServiceImpl();
	}

	@Test
	public void testLogin() {
		System.out.println(userService.login(new User(null, "admin", "admin",
				null)));
		System.out.println(userService.login(new User(null, "admin", "123456",
				null)));
	}

	@Test
	public void testRegistUser() {
		userService.registUser(new User(null, "bbbj168", "123456",
				"bbj168@qq.com"));
	}

	@Test
	public void testExistsUsername() {
		if (userService.existsUsername("admin123")) {
			System.out.println("用户名已存在");
		} else {
			System.out.println("用户名可用");
		}
	}

}
