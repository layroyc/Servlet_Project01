<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>update</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css" />
</head>

<body>
	<form action="${pageContext.request.contextPath }/Update" method="post">
		<table cellpadding="0" cellspacing="0" border="0" class="form_table">
			<tr>
				<td valign="middle" align="right">货品序号</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="goodsId" value="${g.goodsId }" readonly /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">货品类型</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="goodsType" value="${g.goodsType }" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">货品名称</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="goodsName" value="${g.goodsName }" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">货品售价</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="goodsRent" value="${g.goodsRent }" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">货品数量</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="goodsCount" value="${g.goodsCount }" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">供应商</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="supplier" value="${g.supplier }" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">电话</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="telphone" value="${g.telphone }" /></td>
			</tr>
			<tr>
				<td valign="middle" align="right">上架情况</td>
				<td valign="middle" align="left"><input type="text"
					class="inputgri" name="goodsState" value="${g.goodsState }" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" class="button" value="修改" />
		</p>
	</form>
</body>
</html>
