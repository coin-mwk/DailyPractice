/**
 * 
 */
package fitz.dao.impl;

import java.sql.Connection;
import java.util.List;

import fitz.dao.BaseDao;
import fitz.dao.UserDao;
import fitz.pojo.User;
import fitz.utils.JdbcUtils;

/**
 * @author tonystark
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	/**
	 * 功能：想数据表中插入一条数据
	 * @param conn
	 * @param user
	 */
	@Override
	public int insert(Connection conn, User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user (username,password,email) values (?,?,?)";
		int update = update(conn, sql,user.getUsername(),user.getPassword(),user.getEmail());		
		return update;
	}
	
	/**
	 * 功能：通过ID来删除某个用户的数据
	 * @param conn
	 * @param id
	 */
	@Override
	public int deleteById(Connection conn, int id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where id = ?";
		int update = update(conn, sql, id);
		return update;
	}

	/**
	 * 功能：通过ID修改数据表中指定的记录
	 * @param conn
	 * @param username
	 */
	@Override
	public int update(Connection conn, User user) {
		// TODO Auto-generated method stub
		String sql = "update user set username=?,password=?,email=? where id = ?";
		int update = update(conn, sql, user.getUsername(),user.getPassword(),user.getEmail());
		return update;
	}

	/**
	 * 功能：通过ID来查询该用户的数据
	 * @param conn
	 * @param id
	 */	
	@Override
	public User getInfoById(Connection conn, int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id = ?";
		User user = queryOne(conn, User.class, sql, id);
		return user;
	}

	/**
	 * 功能：查询表中所有记录构成的集合
	 * @param conn
	 * @return
	 */
	@Override
	public List<User> getAlll(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "select * from user ";
		List<User> list = getForList(conn, User.class, sql);
		return list;
	}

	/**
	 * 功能：返回数据表中数据的条目数
	 * @param conn
	 * @return
	 */
	@Override
	public long getCount(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from user user";
		return getValue(conn, sql);
	}
}
