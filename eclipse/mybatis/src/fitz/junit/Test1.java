package fitz.junit;


import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import fitz.pojo.User;

public class Test1 {
	
	@Test
	public void test1() throws Exception {

		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		System.out.println("111");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
		  User user = sqlSession.selectOne("fitz.pojo.User.java.selectUserById", 1);
		  System.out.println(user);
		} finally {
		  sqlSession.close();
		  }	
		}

}
