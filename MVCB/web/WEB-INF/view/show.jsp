<%--
  Created by IntelliJ IDEA.
  User: 郝龙飞
  Date: 2021/10/27
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>/WEB-INF/view/user/show.jsp 从request作用域来获取数据</h3>
    <h3>myName：${myName}</h3>
    <h3>myAge：${myAge}</h3>
    <br/>
    <h3>请求参数名和处理器方法的形参名不一样</h3>
    <h3>myName2：${myName2}</h3>
    <h3>myAge2：${myAge2}</h3>
    <br/>
    <h3>使用java对象接收请求的参数</h3>
    <h3>myName3：${myName3}</h3>
    <h3>myAge3：${myAge3}</h3>
    <h3>Student：${student}</h3>
    <br/>

    <h3>使用多个java对象接收请求的参数</h3>
    <h3>myName4：${requestScope.myName4}</h3>
    <h3>myAge4：${myAge4}</h3>
    <h3>schoolName：${sName}</h3>
    <h3>schoolAddress：${requestScope.sAddress}</h3>
    <h3>Student：${requestScope.student}</h3>
    <h3>School：${requestScope.school}</h3>
</body>
</html>
