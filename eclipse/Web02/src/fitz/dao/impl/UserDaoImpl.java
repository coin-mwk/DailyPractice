package fitz.dao.impl;

import java.sql.Connection;

import fitz.dao.UserDao;
import fitz.pojo.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public int insert(Connection conn, User user) {
		String sql = "insert into t_user (username,password,email) values (?,?,?)";
		return update(conn, sql, user.getUsername(),user.getPassword(),user.getEmail());
		
	}

	@Override
	public User queryUsernameAdPassword(Connection conn, User user) {
		String sql = "select id,username,password,email from t_user where username=?,password=?";
		return queryOne(conn, sql, user.getUsername(),user.getPassword());
		
	}

	@Override
	public User queryUsername(Connection conn, String username) {
		String sql = "select id,username,password,email from t_user where username=?";
		return queryOne(conn, sql, username);
	}

}
