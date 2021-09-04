package com.hp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SelectName extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//模糊查询
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//获取请求参数
		String goodsName=request.getParameter("goodsName");

		StringBuffer sb = new StringBuffer();
		if (goodsName != null && !"".equals(goodsName)) {
			sb.append(" and goodsName like '%" + goodsName + "%'");
		}
	}
}
