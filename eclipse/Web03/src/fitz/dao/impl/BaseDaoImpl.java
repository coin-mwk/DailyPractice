package fitz.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 
 * Description:封装多有数据库的相关操作
 * 
 * @author tonystark
 *
 */
public abstract class BaseDaoImpl<T> {

	private QueryRunner queryRunner = new QueryRunner();
	private Class<T> clazz;
	{
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType type = (ParameterizedType) genericSuperclass;
		Type[] arguments = type.getActualTypeArguments();
		clazz = (Class<T>) arguments[0];
	}
	
	
	public int update(Connection conn, String sql, Object ...args) {	
		try {
			return queryRunner.update(conn, sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * Description:查询返回一个实体对象
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 */
	public T queryOne(Connection conn, String sql, Object ...args) {
		try {
			return queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * Description:查询返回一个实体对象的集合
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> queryForList(Connection conn, String sql, Object ...args) {
		try {
			return (List<T>) queryRunner.query(conn, sql, new BeanListHandler(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * Description:查询的特殊情况，返回某个值
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object queryForSingleValue(Connection conn, String sql, Object ...args) {
		try {
			return queryRunner.query(conn, sql, new ScalarHandler(), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
}
