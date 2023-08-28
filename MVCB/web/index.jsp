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
<h3>提交参数给controller</h3>
<form method="post" action="user/login.do">
  姓名：<input type="text" name="name" /><br/>
  年龄：<input type="text" name="age" /><br/>
  <input type="submit" value="提交参数" />
</form>
<h3>请求参数名和处理器方法的形参名不一样</h3>
<form method="get" action="user/login3.do">
  姓名：<input type="text" name="rname"/><br/>
  年龄：<input type="text" name="rage"/><br/>
  <input type="submit" value="提交参数"/>
</form>
<h3>使用java对象接收请求的参数</h3>
<form method="get" action="user/login4.do">
  姓名：<input type="text" name="name"/><br/>
  年龄：<input type="text" name="age"/><br/>
  <input type="submit" value="提交参数"/>
</form>
<h3>使用多个java对象接收请求的参数</h3>
<form method="get" action="user/login5.do">
  姓名：<input type="text" name="name"/><br/>
  年龄：<input type="text" name="age"/><br/>
  学校名：<input type="text" name="sName"/><br/>
  学校地址：<input type="text" name="sAddress"/><br/>
  <input type="submit" value="提交参数"/>
</form>
</body>
</html>
