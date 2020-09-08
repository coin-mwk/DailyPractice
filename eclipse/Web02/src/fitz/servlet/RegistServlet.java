package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.service.UserService;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1 获取请求的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		// 2 检查验证码是否正确
		if ("abcde".equalsIgnoreCase(code)) {
			// 3、检查用户名是否可用
			if (userService.existsUsername(username)) {
				// 用户名已存在
				System.out.println("用户名已存在！ ===>>>>" + username);
				/**
				 * 转发中的斜杠表示http://ip:port/工程名/ ====>>>> 映射到代码的WebContent目录
				 */
				request.getRequestDispatcher("/pages/user/regist.html")
						.forward(request, response);
			} else {
				// 用户名可用
				userService
						.registUser(new User(null, username, password, email));
				// 跳到注册成功页面
				/**
				 * 转发中的斜杠表示http://ip:port/工程名/ ====>>>> 映射到代码的WebContent目录
				 */
				request.getRequestDispatcher("/pages/user/regist_success.html")
						.forward(request, response);
			}
		} else {
			// 验证码错误
			System.out.println("验证码错误：" + code);
			/**
			 * 转发中的斜杠表示http://ip:port/工程名/ ====>>>> 映射到代码的WebContent目录
			 */
			request.getRequestDispatcher("/pages/user/regist.html").forward(
					request, response);
		}
	}

}
