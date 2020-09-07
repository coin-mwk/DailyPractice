package fitz.junit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import fitz.dao.impl.UserDaoImpl;
import fitz.pojo.User;
import fitz.utils.JdbcUtils;

public class UserDaoImplTest {
	UserDaoImpl impl = new UserDaoImpl();

	@Test
	public void testInsert() {
		Connection conn = JdbcUtils.getConnection();
		User user = new User("AAA","aaa","aaa@163.com");
		int i = impl.insert(conn, user);
		if (i>0) {
			System.out.println("插入成功！");
		}else {
			System.out.println("插入失败！");
		}
		JdbcUtils.closeConnection(conn);
	}

	@Test
	public void testDeleteById() {
		Connection conn = JdbcUtils.getConnection();
		int i = impl.deleteById(conn, 2);
		if (i>0) {
			System.out.println("删除成功！");
		}else {
			System.out.println("删除失败！");
		}
		JdbcUtils.closeConnection(conn);
	}

	@Test
	public void testUpdateConnectionUser() {
		Connection conn = JdbcUtils.getConnection();
		User user = new User(7,"fitz","fitz","fitzdl@qq.com");
		int i = impl.update(conn, user);
		if (i>0) {
			System.out.println("修改成功！");
		}else {
			System.out.println("修改失败！");
		}
		JdbcUtils.closeConnection(conn);
	}

	@Test
	public void testGetInfoById() {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			User user = impl.getInfoById(conn, 1);
			if (user!=null) {
				System.out.println(user);
			}else {
				System.out.println("查询失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn);
		}
	}

	@Test
	public void testGetAlll() {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			List<User> list = impl.getAlll(conn);
			if (list.size()>0) {
				list.forEach(System.out::println);
			}else {
				System.out.println("查询失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn);
		}	
	}

	@Test
	public void testGetCount() {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			long count = impl.getCount(conn);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn);
		}	
	}

}
