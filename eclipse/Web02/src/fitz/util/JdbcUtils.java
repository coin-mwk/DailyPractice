package com.atguigu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * JdbcUtils 工具类<br/>
 * 创建一个数据库连接池，提供给用户获取数据库连接，然后关闭数据库连接
 */
public class JdbcUtils {
	
	static DruidDataSource dataSource;
	
	static {
		
		Properties properties = new Properties();
		InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			properties.load(is);
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//			System.out.println( dataSource );
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从数据库连接池中获取连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			// 从数据库连接池中获取数据库连接
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	/**
	 * 关闭连接，释放资源
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
