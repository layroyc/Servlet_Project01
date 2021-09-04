package com.hp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.dao.GoodsDao;
import com.hp.dao.GoodsDaoImpl;
import com.hp.entity.Goods;

public class AddGoods extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//添加
		//设置响应类型及编码格式
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		//获取请求参数
		String goodsType=request.getParameter("goodsType");
		String goodsName=request.getParameter("goodsName");
		String goodsRent =request.getParameter("goodsRent");
		String goodsCount=request.getParameter("goodsCount");
		String supplier=request.getParameter("supplier");
		String telphone =request.getParameter("telphone");

		//转换类型
		Float rent = Float.parseFloat(goodsRent);
		int count = Integer.parseInt(goodsCount);
		

		//创建实现类对象 调用添加方法
		GoodsDao dao = new GoodsDaoImpl();
		Goods goods = new Goods(goodsType,goodsName,rent,count,supplier,telphone);
		//调用单查
		Goods s=dao.selectone(goodsName);

		if(s==null){

			int i = dao.addGoods(goods);
			if(i>0){
				System.out.println("添加成功");
				response.sendRedirect("/cs/SelectAll");
			}else{
				System.out.println("添加失败");
			}
		}else{
			System.out.println("员工已存在");

		}
	}

}
