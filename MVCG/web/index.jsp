<%--
  Created by IntelliJ IDEA.
  User: 郝龙飞
  Date: 2021/11/6
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String basePath = request.getScheme()
          + "://" + request.getServerName()
          + ":" + request.getServerPort()
          + request.getContextPath()
          + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
  <title>index</title>
</head>
<body>
<h3>一个拦截器</h3>
<form method="post" action="user/doSome">
  姓名：<input type="text" name="name"/><br/>
  年龄：<input type="text" name="age"/><br/>
  <input type="submit" value="提交参数"/>
</form>
</body>
</html>
