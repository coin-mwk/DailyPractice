/**
 * 
 */
package fitz.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * Description: 创建数据库连接池，提供用户获取数据库的连接
 * 
 * @author tonystark
 *
 */
public class JdbcUtils {

	static DataSource dataSource = null;	
	static {
		try {
			Properties ps = new Properties();
			InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			ps.load(is);
			dataSource = DruidDataSourceFactory.createDataSource(ps);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	public static Connection getConnection() throws Exception {
		//这里用throws，不用try、catch是因为捕获异常后，后续没有拿到连接还会往下执行
		return dataSource.getConnection();
	}

	public static void closeConnection(Connection conn, Statement ps, ResultSet res) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
