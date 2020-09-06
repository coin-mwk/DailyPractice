/**
 * 
 */
package fitz.junit;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import fitz.pojo.User;
import fitz.utils.JdbcUtils;

/**
 * @author tonystark
 *
 */
public class Table_book_test {
	
	@Test
	public void test1() throws Exception {
		//查询一条记录
		String sql = "select id,username,password,email from t_user1 where id = ?";
		User user = getInstance(User.class,sql, 2);
		System.out.println(user);
//		查询多条记录
		String sql1 = "select id,username,password,email from t_user1 where id < ?";
		List<User> setList = getForList(User.class, sql1, 3);
		setList.forEach(System.out::println);
//		Iterator<User> it = setList.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}
//		for(User a:setList) {
//			System.out.println(a);
//		}
	}
	
	/**
	 * 查询某个用户的密码
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		System.out.println("==========密码查询系统===========");
		System.out.println("请输入要查询的用户名");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.next();
		String sql = "select password from t_user where username = ?";
		User user = getInstance(User.class, sql, username);
		System.out.println("该用户的密码为："+user.getPassword());
	}
	
	/**
	 * 从控制台向数据库中插入一条数据
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		System.out.println("==========向数据表中插入数据===========");
		System.out.println("请依次输入要插入的的用户名、密码、邮箱");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.next();
		String password = scanner.next();
		String email = scanner.next();
		String sql = "insert into t_user (username,password,email) values (?,?,?)";
		int update = update(sql, username,password,email);
		System.out.println("是否添加成功："+update);
	}
	
	
	public int update(String sql, Object ...args){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			int ex = ps.executeUpdate();
			return ex;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn, ps);
		}
		return 0;
	}
	
	/**
	 * 实现针对不同表的通用操作，查询返回多条记录
	 * @param <T>
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T> getForList(Class<T> clazz,String sql, Object ...args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				//填充占位符
				ps.setObject(i+1, args[i]);
			}
			
			res = ps.executeQuery();
			//获取结果集元数据
			ResultSetMetaData metaData = res.getMetaData();
			//获取结果集的列数
			int columnCount = metaData.getColumnCount();
			//创建集合用于存储多条记录（对象）
			ArrayList<T> set = new ArrayList<>();
			while(res.next()) {
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					//获取列值
					Object columnValue = res.getObject(i+1);
					//获取列的别名
					String columnLabel = metaData.getColumnLabel(i+1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				set.add(t);
			}		
			return set;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn, ps, res);
		}	
		return null;		
	}
	
	/**
	 * 实现针对不同表的通用操作，查询返回一条记录
	 * @param <T>
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> T getInstance(Class<T> clazz,String sql, Object ...args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			res = ps.executeQuery();
			//获取结果集元数据
			ResultSetMetaData metaData = res.getMetaData();
			//获取结果集的列数
			int columnCount = metaData.getColumnCount();
			if (res.next()) {
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					//获取列值
					Object columnValue = res.getObject(i+1);
					//获取列的别名
					String columnLabel = metaData.getColumnLabel(i+1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				return t;
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn, ps, res);
		}	
		return null;		
	}

}
