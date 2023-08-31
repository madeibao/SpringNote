<%--
  Created by IntelliJ IDEA.
  User: 郝龙飞
  Date: 2021/10/27
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<p>第二个springMVC项目</p>
<form method="get" action="user/some.do">
  <input type="submit" value="发送some.do请求(GET请求)" />
</form>
<form method="post" action="user/other.do">
  <input type="submit" value="发送other.do请求(POST请求)" />
</form>
<form method="get" action="user/first.do">
  <input type="submit" value="发送first.do请求(get请求)(不指定请求方式，没有限制)" />
</form>
<form method="post" action="user/first.do">
  <input type="submit" value="发送first.do请求(POST请求)(不指定请求方式，没有限制)" />
</form>
</body>
</html>
