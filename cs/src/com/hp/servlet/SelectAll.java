package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.dao.GoodsDao;
import com.hp.dao.GoodsDaoImpl;
import com.hp.entity.Goods;

public class SelectAll extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置响应类型和编码格式
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		GoodsDao dao= new GoodsDaoImpl();
		ArrayList<Goods> good=dao.selectAll();
		for (Goods goods : good) {
			System.out.println(goods.getGoodsName());
		}
		//获取session对象
		HttpSession session=request.getSession();
		session.setAttribute("good", good);
		//请求转发
		request.getRequestDispatcher("/selectAll.jsp").forward(request, response);;

	}

}
