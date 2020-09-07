/**
 * 
 */
package fitz.dao;

import java.sql.Connection;
import java.util.List;

import fitz.pojo.User;

/**功能：此接口用于规范针对于User表的常用操作
 * @author tonystark
 *
 */
public interface UserDao {

	
	/**
	 * 功能：想数据表中插入一条数据
	 * @param conn
	 * @param user
	 */
	int insert(Connection conn, User user);	
	
	/**
	 * 功能：通过ID来删除某个用户的数据
	 * @param conn
	 * @param id
	 */
	int deleteById(Connection conn, int id) ;	
	
	/**
	 * 功能：修改数据表中指定的记录
	 * @param conn
	 * @param username
	 */
	int update(Connection conn, User user) ;
	
	/**
	 * 功能：通过ID来查询该用户的数据
	 * @param conn
	 * @param id
	 */	
	User getInfoById(Connection conn, int id) ;
	
	/**
	 * 功能：查询表中所有记录构成的集合
	 * @param conn
	 * @return
	 */
	List<User> getAlll(Connection conn);
	
	/**
	 * 功能：返回数据表中数据的条目数
	 * @param conn
	 * @return
	 */
	long getCount(Connection conn);
	
	  
	
}
