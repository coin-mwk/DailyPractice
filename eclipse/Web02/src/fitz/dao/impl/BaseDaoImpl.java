package com.atguigu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.util.JdbcUtils;

public abstract class BaseDaoImpl {

	private QueryRunner queryRunner = new QueryRunner();

	/**
	 * 执行insert、update、delete语句
	 * 
	 * @param sql
	 *            要执行的sql语句
	 * @param args
	 *            占位符的参数值
	 * @return -1表示执行失败，其他值表示执行的行数
	 */
	public int update(String sql, Object... args) {
		Connection conn = JdbcUtils.getConnection();
		/**
		 * 执行insert、update、delete语句
		 */
		try {
			return queryRunner.update(conn, sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return -1;
	}

	/**
	 * 执行查询返回值是一个javaBean的sql语句
	 * 
	 * @param sql
	 *            查询的sql语句
	 * @param type
	 *            返回javaBean的具体类型
	 * @param args
	 *            sql语句中占位符的参数值
	 * @return 查询失败返回null，有值就成功！
	 */
	public <T> T queryOne(String sql, Class<T> type, Object... args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return null;
	}

	/**
	 * 执行查询返回值是多个javaBean的sql语句
	 * 
	 * @param sql
	 *            查询的sql语句
	 * @param type
	 *            返回javaBean的具体类型
	 * @param args
	 *            sql语句中占位符的参数值
	 * @return 查询失败返回null，有值就成功！
	 */
	public <T> List<T> queryList(String sql, Class<T> type, Object... args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn, sql, new BeanListHandler<T>(type),
					args);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return null;
	}

	/**
	 * 执行查询返回值是单个列的sql语句
	 * 
	 * @param sql
	 *            查询的sql语句
	 * @param type
	 *            返回javaBean的具体类型
	 * @param args
	 *            sql语句中占位符的参数值
	 * @return 查询失败返回null，有值就成功！
	 */
	public Object queryForSingleValue(String sql, Object... args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			/**
			 * BeanHandler 是将查询到的结果集封装成为一个javaBean返回<br/>
			 * BeanListHandler 是将查询到的结果集封装成为一个list集合，并且里面每个都是指定的javaBean类型<br/>
			 * ScalarHandler 是将查询到的某个列的结果返回。<br/>
			 */
			return queryRunner.query(conn, sql, new ScalarHandler(), args);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return null;
	}

}
