package com.hp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.dao.GoodsDao;
import com.hp.dao.GoodsDaoImpl;
import com.hp.entity.Goods;

public class Update extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//修改
		//设置编码格式和响应类型
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//获取请求参数 转换类型
		String goodsId =request.getParameter("goodsId");
		String goodsType=request.getParameter("goodsType");
		String goodsName = request.getParameter("goodsName");
		String goodsRent =request.getParameter("goodsRent");
		String goodsCount=request.getParameter("goodsCount");
		String supplier=request.getParameter("supplier");
		String telphone =request.getParameter("telphone");
		String goodsState =request.getParameter("goodsState");

		//转换类型
		int id=Integer.parseInt(goodsId);
		Float goodsRent2 = Float.parseFloat(goodsRent);
		int goodsCount2 = Integer.parseInt(goodsCount);
		int goodsState2=Integer.parseInt(goodsState);

		//创建实现类对象 调用修改方法
		GoodsDao dao = new GoodsDaoImpl();
		Goods goods = new Goods(id,goodsType,goodsName,goodsRent2,goodsCount2,supplier,telphone,goodsState2);
		
		int i =dao.update(goods);
		if(i>0){
			System.out.println("修改成功");
			response.sendRedirect("/cs/SelectAll");
		}else{
			System.out.println("修改失败");
		}
	}

}
