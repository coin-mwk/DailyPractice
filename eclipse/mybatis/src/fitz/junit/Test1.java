package fitz.junit;


import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import fitz.pojo.User;

public class Test1 {
	
	public static void main(String[] args) throws Exception {
		//加载mybatis的配置文件
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		System.out.println(sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
		  User user = sqlSession.selectOne("fitz.pojo.User.selectUserById", 1);
		  System.out.println(user);
		} finally {
		  sqlSession.close();
		  }	
		}

}
