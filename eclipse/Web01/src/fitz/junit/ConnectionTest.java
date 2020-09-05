package fitz.junit;
/**
 * 
 * @author tonystark
 *
 */

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

public class ConnectionTest {

	
	/**
	 * 方式一
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		//获取Driver类实现对象  
		Driver driver = new com.mysql.jdbc.Driver();
		
		String url = "jdbc:mysql://localhost/book_test";
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "hhha120.");
		Connection connection = driver.connect(url, info);
		System.out.println(connection);
		connection.close();
	}
	
	@Test
	public void test2() throws Exception {
		//通过反射获取Driver实现类的对象，不调用任何第三方API，具有更好的移植性
		Driver driver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
		//Class clazz = Class.forName("com.mysql.jdbc.Driver");
		//Driver driver = (Driver) clazz.newInstance();
		String url = "jdbc:mysql://localhost/book_test";
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "hhha120.");
		Connection connection = driver.connect(url, info);
		System.out.println(connection);
		connection.close();
		
	}
	
	@Test
	public void test3() throws Exception {
		String url = "jdbc:mysql://localhost/book_test";
		String user = "root";
		String password = "hhha120.";
		//1、利用反射获取Driver实现类的对象
		Driver driver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
		//2、注册驱动
		DriverManager.registerDriver(driver);
		//1、2两步可以不写，直接写Class.forName("com.mysql.jdbc.Driver")，因为加载完Driver类后会主动注册该驱动，甚至MySQL此加载也可省略，在MySQL驱动里也主动加载了  
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("test3"+connection);
		connection.close();
	}
}
