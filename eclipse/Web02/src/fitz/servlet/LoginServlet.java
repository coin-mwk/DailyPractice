package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1、获取请求的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		2、调用userService.login()
		User loginUser = userService.login(new User(null, username, password, null));
//		3、根据返回的结果判断用户是否登录成功
		if (loginUser == null) {
//			失败
//				跳回登录页面
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
		} else {
//			成功
//				跳到登录成功页面
			request.getRequestDispatcher("/pages/user/login_success.html").forward(request, response);
		}
	}
}
