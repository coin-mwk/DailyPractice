/**
 * 
 */
package fitz.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fitz.utils.JdbcUtils;

/**
 * 功能：封装了针对于数据表的通用操作
 *
 * @author tonystark
 *
 */
public abstract class BaseDao {

	private ResultSet res;

	/**
	 * 功能：通用的修改操作，可以处理增删改查
	 * 操作失败返回0，操作成功返回数据表中影响的行数
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 */
	public int update(Connection conn, String sql, Object ...args){
		PreparedStatement ps = null;
		try {
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
			JdbcUtils.closeConnection(null, ps);
		}
		return 0;
	}
	
	/**
	 * 功能：查询并返回一个对象
	 * @param <T>
	 * @param conn
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> T queryOne (Connection conn, Class<T> clazz, String sql, Object ...args) {
		
		PreparedStatement ps = null;
		ResultSet res = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			res = ps.executeQuery();
			//获取结果集元数据
			ResultSetMetaData metaData = res.getMetaData();
			//获取列数
			int columnCount = metaData.getColumnCount();
			if (res.next()) {
				T t = clazz.newInstance();
				for (int j = 0; j < columnCount; j++) {
					//获取列值
					Object columnValue = res.getObject(j+1);
					//获取列的别名
					String columnLabel = metaData.getColumnLabel(columnCount);
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
			JdbcUtils.closeConnection(null, ps,res);
		}
		return null;
		
	}

		
	/**
	 * 功能：查询并返回多个对象的集合
	 * @param <T>
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T> getForList(Connection conn, Class<T> clazz,String sql, Object ...args){
		PreparedStatement ps = null;
		ResultSet res = null;
		try {
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
	 * 功能:用于查询特殊值得特殊方法
	 * @param <E>
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getValue(Connection conn, String sql, Object ...args) {
		PreparedStatement ps = null;
		res = null;
		try {
			conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {	
				ps.setObject(i+1, args[i]);
			}
			 res = ps.executeQuery();
			if(res.next()) {
				return (E)res.getObject(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(null, ps, res);
		}
		return null;
	}
	
	
	
}
