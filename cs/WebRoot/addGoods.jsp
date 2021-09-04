<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>add Emp</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css" />
</head>

<body>

	<form action="/cs/AddGoods" method="post">
		<table cellpadding="0" cellspacing="0" border="0" class="form_table">
			<tr>
				<td valign="middle" align="right">货品类型</td>
				<td valign="middle" align="left">
				<select class="inputgri" name="goodsType">
					<option>饮料</option>
					<option>食品</option>
					<option>洗漱</option>
				</select>
			</tr>
			<tr>
				<td valign="middle" align="right">货品名称</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="goodsName" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">货品售价</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="goodsRent" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">货品数量</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="goodsCount" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">供应商</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="supplier" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">电话</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="telphone" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" class="button" value="添加" />
		</p>
	</form>

</body>
</html>
