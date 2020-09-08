package com.atguigu.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atguigu.util.JdbcUtils;

public class JdbcUtilsTest {

	@Test
	public void testJdbcUtils() throws Exception {
		
		System.out.println( JdbcUtils.getConnection() );
		
	}
	
}
