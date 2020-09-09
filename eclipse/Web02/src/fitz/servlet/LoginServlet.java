package fitz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fitz.pojo.User;
import fitz.service.UserService;
import fitz.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2222");
//		获取用户输入的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		判断用户名是
		User login = userService.login(new User(null,username,password,null));
		System.out.println(login);
		if (login != null) {
//			输入的用户名、密码正确,转到登录成功页面
			request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
		}else {
//			输入的用户名或密码有误，转到登录主页
			request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
		}
		
	}

}
