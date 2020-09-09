package fitz.dao;

import java.sql.Connection;

import fitz.pojo.User;

/**
 * 
 * Description:封装User类所有功能的抽象方法
 * 
 * @author tonystark
 *
 */
public interface UserDao {

	/**
	 * 
	 * Description:注册时添加用户
	 * @param conn
	 * @param user
	 * @return
	 */
	int insert(Connection conn, User user);
	
	/**
	 * 
	 * Description:查询用户名和密码是否正确
	 * @param conn
	 * @param user
	 * @return
	 */
	User queryUsernameAdPassword(Connection conn, User user);
	
	/**]
	 * 
	 * Description:查询用户名是否存在
	 * @param conn
	 * @param user
	 * @return
	 */
	User queryUsername(Connection conn, String username);
}
