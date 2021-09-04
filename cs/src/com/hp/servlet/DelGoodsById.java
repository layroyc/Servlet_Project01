package com.hp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.dao.GoodsDao;
import com.hp.dao.GoodsDaoImpl;

public class DelGoodsById extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//删除
		//设置编码格式和响应类型
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		//获取请求参数 转换类型
		String goodsId=request.getParameter("goodsId");
		int id=Integer.parseInt(goodsId);

		//调用dao创建实现类对象 调用删除方法
		GoodsDao dao = new GoodsDaoImpl();
		int i = dao.delete(id);
		if(i>0){
			System.out.println("删除成功");
			//删除之后重新进入数据库进行全查
			response.sendRedirect("/cs/SelectAll");
		}else{
			System.out.println("删除失败");
		}

	}

}
