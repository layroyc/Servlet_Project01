<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>list</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css" />
</head>
<body>
	<div>
		<p align="left" style="color: blue;">超市信息管理平台</p>
	</div>
	<div>
		<form action="${pageContext.request.contextPath }/SelectName" method="post">
			货品名称:<input type="text" name="goodsName" />&nbsp; 
			<input type="submit" value="模糊查询"/>
		</form>
	</div>
	<div style="text-align:right;">
		<a href="/cs/addGoods.jsp"><input type="button" value="添加"></a>
	</div>
	<form action="" method="post">
		<table class="table" style="text-align:center;">
			<tr class="table_header">
				<td>货品编号</td>
				<td>货品类型</td>
				<td>货品名称</td>
				<td>货品售价</td>
				<td>货品数量</td>
				<td>供货商</td>
				<td>电话</td>
				<td>上架情况</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${sessionScope.good }" var="goods">
				<tr class="row1">
					<td>${goods.goodsId }</td>
					<td>${goods.goodsType }</td>
					<td>${goods.goodsName }</td>
					<td>${goods.goodsRent }</td>
					<td>${goods.goodsCount }</td>
					<td>${goods.supplier }</td>
					<td>${goods.telphone }</td>
					<td>${goods.goodsState }</td>
					<td><a
						href="${pageContext.request.contextPath }/OneServlet?goodsId=${goods.goodsId }"><input
							type="button" value="详情"></a> <a
						href="${pageContext.request.contextPath }/DelGoodsById?goodsId=${goods.goodsId }"><input
							type="button" value="删除"></a>&nbsp;</td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>
