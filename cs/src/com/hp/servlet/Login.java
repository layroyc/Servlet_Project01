package com.hp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.dao.UserDao;
import com.hp.dao.UserDaoImpl;
import com.hp.entity.User;

public class Login extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置响应类型和编码格式
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//获取对象
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name+"--------"+pwd);
		//调用dao
		UserDao user = new UserDaoImpl();
		User u = user.selectUP(name, pwd);
		if(u != null){
			//用户存在
			if(u.getPwd().equals(pwd)){
				System.out.println("登录成功");
				request.getRequestDispatcher("/SelectAll").forward(request, response);
			}else{
				System.out.println("登录失败");
			}
		}else{
			System.out.println("用户不存在");
		}
	}

}
