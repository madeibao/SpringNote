<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/16
  Time: 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p><a href="image/1.png">点击访问静态资源</a></p>
    <form action="doSome.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
</body>
</html>
