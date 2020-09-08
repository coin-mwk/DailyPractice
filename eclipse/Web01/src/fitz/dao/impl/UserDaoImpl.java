/**
 * 
 */
package fitz.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
public class UserDaoImpl extends BaseDao<User> implements UserDao {
	
	/**
	 * 功能：想数据表中插入一条数据
	 * @param conn
	 * @param user
	 */
	@Override
	public int insert(Connection conn, User user) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user (username,password,email) values (?,?,?)";
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
		String sql = "delete from t_user where id = ?";
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
		int id = user.getId();
		String sql = "update t_user set username=?,password=?,email=? where id = ?";
		int update = update(conn, sql, user.getUsername(),user.getPassword(),user.getEmail(),id);
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
		String sql = "select username,password,email from t_user where id = ?";
		User user = queryOne(conn, sql, id);
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
		String sql = "select * from t_user ";
		List<User> list = getForList(conn, sql);
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
		String sql = "select count(*) from t_user";
		return getValue(conn, sql);
	}
}
