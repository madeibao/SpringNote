<%--
  Created by IntelliJ IDEA.
  User: 郝龙飞
  Date: 2021/11/6
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <h3>hello.jsp</h3>
    <h3>request域(student对象):</h3>
    <h3>myName：${student.name}</h3>
    <h3>myAge：${student.age}</h3>
    <h3>request域(直接得到属性):</h3>
    <h3>myName：${myName}</h3>
    <h3>myAge：${myAge}</h3>
    <h3>param请求的参数(转发):</h3>
    <h3>myName：${param.name}</h3>
    <h3>myAge：${param.age}</h3>
    <h3>param请求的参数(重定向):</h3>
    <h3>myName：${param.myName}</h3>
    <h3>myAge：${param.myAge}</h3>
    </body>
</html>
