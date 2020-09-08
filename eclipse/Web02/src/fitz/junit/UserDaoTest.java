package com.atguigu.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

public class UserDaoTest {
	
	static UserDao userDao;
	/**
	 * @BeforeClass 注解可以让被标注的方法在所有测试方法执行之前执行一次<br/>
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDao = new UserDaoImpl();
	}

	@Test
	public void testQueryUserByUsernameAndPassword() {
		System.out.println( userDao.queryUserByUsernameAndPassword("admin", "admin") );
		System.out.println( userDao.queryUserByUsernameAndPassword("admin", "123456") );
	}

	@Test
	public void testSaveUser() {
		System.out.println( userDao.saveUser(new User(null, "wzg168", "123456", "wzg168@qq.com")) );
		System.out.println( userDao.saveUser(new User(null, "aaaaaa", "666666", "wzg168@qq.com")) );
	}

	@Test
	public void testQueryUserByUsername() {
		System.out.println( userDao.queryUserByUsername("admin") );
		System.out.println( userDao.queryUserByUsername("wzg168") );
	}

}
