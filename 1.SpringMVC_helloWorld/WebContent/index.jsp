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
</body>
</html>