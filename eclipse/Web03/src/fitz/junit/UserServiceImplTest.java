package fitz.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import fitz.pojo.User;
import fitz.service.impl.UserServiceImpl;

public class UserServiceImplTest {

	static UserServiceImpl userServiceImpl;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userServiceImpl = new UserServiceImpl();
		System.out.println("1");
	}
	

	@Test
	public void testLogin() {
		System.out.println("2");
		System.out.println(userServiceImpl.login(new User(null, "fitz","fitz","fitz@qq.com")));
		//用户名错
		System.out.println(userServiceImpl.login(new User(null, "ftz","fitz","fitz@qq.com")));
	}

	@Test
	public void testRegisteUser() {
		System.out.println(userServiceImpl.registeUser(new User(null,"fitz","fitz","fitz@qq.com")));
		System.out.println(userServiceImpl.registeUser(new User(null,"fitzz","fitz","fitz@qq.com")));
	}

	@Test
	public void testExistsUsername() {
		
	}

}
