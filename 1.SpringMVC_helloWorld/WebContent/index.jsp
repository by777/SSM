<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="hello">Hello。</a>
<hr/>
<h1>@RequestMapping-Ant风格url模糊匹配。</h1>
<a href="antTest01">精确匹配/antTest01</a>
<br>
<a href="antTest02">*匹配/antTest0?</a>


<hr/>
<h1>PathVariable匹配url变量</h1>
<a href="user/admin">发送请求：user/admin</a>
<br>
<a href="user/root">发送请求：user/root</a>
<br>
<a href="user/root1">发送请求：user/root1 </a>
<br>
<a href="user/root1/">发送请求：user/root1/ 跟上面一样</a>
<br>
<a href="user/root1/1111">发送请求：user/root1/1111 会报404</a>


<br>
<a href="handle02?username=tomcat">发送请求handle?username=tomcat：带有参数</a>
<hr>
<form action="book" method="post">
书名：<input type="text" value="" name="bookName">
作者：<input type="text" value="" name="author">
价格：<input type="text" value="" name="price">
库存：<input type="text" value="" name="stock">
销量：<input type="text" value="" name="sales">
<hr>作者地址：
省：<input type="text" value="" name="address.province">
市：<input type="text" value="" name="address.city">
街道：<input type="text" value="" name="address.street">
<input type="submit">
提交的请求可能有乱码：
乱码分为
请求乱码、GET改server.xml:URIEncoding="UTF-8"
POST:在第一次请求参数之前设置request.setCharacterEncoding("UTF-8")\修改characterEncodingFilter
响应乱码:response.setContentType("text/html;charset=utf-8")
</form>
</body>
</html>