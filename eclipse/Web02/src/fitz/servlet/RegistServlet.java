package fitz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fitz.pojo.User;
import fitz.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取用户输入的信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		//2、验证 验证码是否正确
		if (code.equalsIgnoreCase("Fitz")) {
			//验证码正确后，验证该用户是否存在，
			boolean existsUsername = userServiceImpl.existsUsername(username);
			if (existsUsername) {
				//该用户名已存在，返回注册页面
				request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
			}else {
				//该用户名不存在，可以注册
				int registeUser = userServiceImpl.registeUser(new User(null,username,password,email));
				if (registeUser>0) {
					System.out.println("注册成功！");
					request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
				}
			}
		}else {
			//验证码不正确，返回注册页面
			request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
		}
	}

}
