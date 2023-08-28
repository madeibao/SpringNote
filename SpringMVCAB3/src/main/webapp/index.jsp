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
    <p>SpringMVC</p>
    <form action="test/receive.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>


    <form action="test/para.do" method="post">
        姓名：<input type="text" name="rname"><br/>
        年龄：<input type="text" name="rage"><br/>
        <input type="submit" value="提交参数">
    </form>


    <form action="test/object.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
