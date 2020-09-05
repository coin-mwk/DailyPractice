package fitz.junit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import fitz.utils.JdbcUtils;

public class JdbcTest {
	
	
	@Test
	public void JdbcTest1() throws Exception {
		System.out.println();
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from t_user";
		Statement createStatement = conn.createStatement();
		ResultSet rs = createStatement.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));			
		}
	}

}
