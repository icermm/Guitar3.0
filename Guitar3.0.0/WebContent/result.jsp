<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <style type="text/css">
        td
        {
         border-width:1px;
         border-style:solid;
         text-align:center;
         height:40px;
        }
</style>
<title>搜索结果</title>
</head>

<body>
<h1 align=center>Rick的 吉他小屋</h1>
<hr/>
    <h2 align=center>搜索结果</h2>
    <table width="600"  border="1" cellpadding="0" cellspacing="0" align="center">

<tr>
    <td>系列号</td>
	<td>厂商</td>
	<td>型号</td>
	<td>类型</td>
	<td>后部材质</td>
	<td>前部材质</td>
	<td>价格</td>
</tr>

<c:forEach items="${res}" var="p">
	<tr>
	<td>${p.serialNumber}</td>
	<td>${p.getSpec().getBuilder()}</td>
	<td>${p.getSpec().getModel()}</td>	
	<td>${p.getSpec().getType()}</td>
	<td>${p.getSpec().getBackWood()}</td>
    <td>${p.getSpec().getTopWood()}</td>
	<td>${p.price}</td>	
	</tr>

</c:forEach>
</table>

</body>
</html>