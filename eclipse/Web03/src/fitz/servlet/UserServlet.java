package fitz.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fitz.pojo.User;
import fitz.service.impl.UserServiceImpl;

/**
 * 处理用户注册于用户登录的业务
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户输入的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//判断用户名是
		User login = userServiceImpl.login(new User(null,username,password,null));
		if (login != null) {
			//输入的用户名、密码正确,转到登录成功页面
			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
		}else {
//			输入的用户名或密码有误，转到登录主页;
			request.setAttribute("errmsg", "输入的用户名或密码有误，请重新输入");
			request.setAttribute("username", username);
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
		}
	}

	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				request.setAttribute("errmsg", "该用户名已存在");
				request.setAttribute("username", username);
				request.setAttribute("code", code);
				request.setAttribute("email", email);
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}else {
				//该用户名不存在，可以注册
				int registeUser = userServiceImpl.registeUser(new User(null,username,password,email));
				if (registeUser>0) {
//					System.out.println("注册成功！");
					request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
				}
			}
		}else {
			//验证码不正确，返回注册页面
			request.setAttribute("errmsg", "验证码错误，请重新输入");
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServlet userServlet = new UserServlet();
		String action = (String) request.getParameter("action");
		try {
			Method method = UserServlet.class.getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);
//			method.setAccessible(true);
			method.invoke(userServlet,request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
