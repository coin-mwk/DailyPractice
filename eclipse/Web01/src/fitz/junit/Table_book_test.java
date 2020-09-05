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
//		String sql = "select id,username,password,email from t_user where id = ?";
//		User user = getInstance(User.class,sql, 3);
//		System.out.println(user);
		//查询多条记录
		String sql = "select id,username,password,email from t_user where id < ?";
		List<User> setList = getForList(User.class, sql, 5);
		setList.forEach(System.out::println);
		Iterator<User> it = setList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		for(User a:setList) {
			System.out.println(a);
		}
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
