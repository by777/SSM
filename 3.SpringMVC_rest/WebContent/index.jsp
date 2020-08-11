<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>发起图书的增删改查请求-rest风格</h1>
<span>
/book/1 GET:查询1号图书<br>
/book/1 DELETE:删除1号图书<br>
/book/1 PUT:更新1号图书<br>
/book   POST:添加1号图书<br>
1.SpringMVC中有一个Filter可以把一个普通的请求转化为规定形式的请求
2.发送POST形式请求，表单项中携带_method的参数
<br>
</span>
<hr>
<a href="book/1">发送！查询！</a><br>
<form action="book" method="post">
	<input type='submit' value='发送！添加！'>
</form>

<form action="book/1" method="post">	
	<input name="_method" value="delete">
	<input type="submit" value='发送！删除！'>
</form>

<form action="book/1" method="post">	
	<input name="_method" value="PUT">
	<input type="submit" value='发送！更新！'>
</form>
</body>
</html>