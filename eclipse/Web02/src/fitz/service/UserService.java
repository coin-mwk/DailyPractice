package fitz.service;

import fitz.pojo.User;

/**
 * 
 * Description:一个业务一个方法
 * 
 * @author tonystark
 *
 */
public interface UserService {

	User login(User user);
	
	int registeUser(User user);
	
	boolean existsUsername(String username);
}
