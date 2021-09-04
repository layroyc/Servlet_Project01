package com.hp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.dao.GoodsDao;
import com.hp.dao.GoodsDaoImpl;
import com.hp.entity.Goods;

public class OneServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//单查
				//修改的时候需要先根据id查找到要修改对象的信息展示到修改页面上
				//设置响应类型和编码格式
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				
				//获取请求参数 转换类型
				String i =request.getParameter("goodsId");
				int id=Integer.parseInt(i);
				
				//创建实现类对象 调用根据id的单查方法
				GoodsDao dao = new GoodsDaoImpl();
				Goods g = dao.selectById(id);

				//查到之后存放到作用域中
				HttpSession session = request.getSession();
				session.setAttribute("g", g);
				//跳转到修改页面
				response.sendRedirect("/cs/updateGoods.jsp");
	}

}
