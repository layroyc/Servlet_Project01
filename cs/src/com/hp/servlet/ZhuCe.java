package com.hp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.dao.UserDao;
import com.hp.dao.UserDaoImpl;
import com.hp.entity.User;


public class ZhuCe extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String phone=request.getParameter("phone");
		
		User user = new User(name,pwd,phone);
		UserDao dao=new UserDaoImpl();
		User u = dao.selectUP(name, pwd);
		
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		
		if(u==null){
			//不存在 注册
			int a=dao.zhuCe(name, pwd, phone);
			if(a>0){
				System.out.println("注册成功！");
				int  random=(int)Math.round((Math.random()+1)*1000);
				session.setAttribute("random", random);
			 response.sendRedirect("/cs/login.jsp");
			}else{
				System.out.println("注册失败！");
				
			}
		}else{
			System.out.println("用户已经存在");
			response.sendRedirect("/cs/zhuce.jsp");
		}
		
	}

}
