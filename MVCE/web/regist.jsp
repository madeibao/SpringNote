<%--
  Created by IntelliJ IDEA.
  User: 郝龙飞
  Date: 2021/11/5
  Time: 10:13
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
<html>
<head>
    <title>注册</title>
    <base href="<%=basePath%>" />
</head>
<body>
<form method="post" action="student/regist">
    id:<input type="text" name="id"><br/>
    name:<input type="text" name="name"><br/>
    age:<input type="text" name="age"><br/>
    <input type="submit" value="注册" />
</form>
</body>
</html>