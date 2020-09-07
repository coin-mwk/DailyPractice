package fitz.junit;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import fitz.pojo.User;
import fitz.utils.JdbcUtils;

/**
 * 事务的体现
 * 解决脏读
 * @author tonystark
 *
 */

public class TransactionTest {
	
	
	@Test
	public void test1() throws Exception {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn.getTransactionIsolation());
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		System.out.println(conn.getTransactionIsolation());
		conn.setAutoCommit(false);
		System.out.println(conn.getAutoCommit());
		String sql = "select password from t_user where username = ?";
		User user = queryOne(conn, User.class, sql, "admin");
		System.out.println(user.getPassword());
		
	} 
	
	@Test
	public void test2() throws Exception {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn.getTransactionIsolation());
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		System.out.println(conn.getTransactionIsolation());
		conn.setAutoCommit(false);
		System.out.println(conn.getAutoCommit());
		String sql = "update t_user set password = ? where username = ?";
		int update = update(conn, sql, "admin123", "admin");
		if (update>0) {
			System.out.println("修改成功！");
		}else {
			System.out.println("修改失败！");
		}
		
	}
	
	
	int update(Connection conn, String sql, Object ...args){
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
//			JdbcUtils.closeConnection(null, ps);
		}
		return 0;
	}
	
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
//			JdbcUtils.closeConnection(null, ps,res);
		}
		return null;
		
	}
}
