package fitz.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import fitz.dao.impl.UserDaoImpl;
import fitz.pojo.User;
import fitz.service.UserService;
import fitz.utils.JdbcUtils;

public class UserServiceImpl implements UserService {

	UserDaoImpl userDaoImpl = new UserDaoImpl();
	@Override
	public User login(User user) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			//若有事务的操作，要先将自动提交关闭
//			conn.setAutoCommit(false);		
			return userDaoImpl.queryUsernameAdPassword(conn, user);
		} catch (Exception e) {
			//若有事务的操作，这里抛出异常后要有回滚操作
//			conn.rollback();
			e.printStackTrace();
		}finally {
			//若有事务的操作，此处关闭连接，要将自动提交设为true，不影响该数据库连接被放回数据库连接池后的再次操作
//			conn.setAutoCommit(true);
			JdbcUtils.closeConnection(conn, null, null);
		}
		return null;	
		
	}

	@Override
	public int registeUser(User user) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			return userDaoImpl.insert(conn, user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn, null, null);
		}
		return 0;	
	}

	@Override
	public boolean existsUsername(String username) {
		Connection conn = null;;
		try {
			conn = JdbcUtils.getConnection();
			User user2 = userDaoImpl.queryUsername(conn, username);
			if (user2 != null) {
				//返回true，表明该用户名已存在
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn, null, null);
		}
		//返回false表明该用户名不存在
		return false;
	}

}
