<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
<%@include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	$(function(){
		$("#sub_btn").click(function(){

// 			验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
			//1 先获取用户名输入框中的内容
			var usernameText = $("#username").val();
			//2 创建正则表达式对象
			var usernamePatt = /^\w{5,12}$/;
			//3 调用test方法验证结果
			if ( !usernamePatt.test(usernameText) ) {
				//4 如果不合法，要提示用户，并阻止提交。
				$("span.errorMsg").text("用户名不合法!");
				return false;
			}
			

// 			验证密码：必须由字母，数字下划线组成，并且长度为5到12位
			//1 先获取密码输入框中的内容
			var passwordText = $("#password").val();
			//2 创建正则表达式对象
			var passwodPatt = /^\w{5,12}$/;
			//3 调用test方法验证结果
			if ( !passwodPatt.test(passwordText) ) {
				//4 如果不合法，要提示用户，并阻止提交。
				$("span.errorMsg").text("密码不合法!");
				return false;
			}

			
			$("span.errorMsg").text("");
			// return false 可以阻止元素的默认行为。
			return true;
		});
	});
</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">${empty requestScope.errmsg ? "请输入用户名和密码" : requestScope.errmsg}</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="login">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" 
										autocomplete="off" tabindex="1" name="username" id="username"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" 
										autocomplete="off" tabindex="1" name="password" id="password"/>
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>