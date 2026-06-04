<%--
  Created by IntelliJ IDEA.
  User: 郝龙飞
  Date: 2021/10/27
  Time: 20:54
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
  <title>Title</title>
</head>
<body>
  <h3></h3>
  <form method="post" action="user/some.do">
    姓名：<input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"/><br/>
    <input type="submit" value="提交参数"/>
    <img src="imgs/p2.jpg" style="height: 100px"/>
  </form>
  <br/>
  <h3>当方法返回ModelAndView，实现forward请求转发</h3>
  <form method="get" action="forward.do">
    姓名：<input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"/><br/>
    <input type="submit" value="提交参数"/>
  </form>
  <h3>当方法返回ModelAndView，实现redirect请求重定向</h3>
  <form method="post" action="redirect.do">
    姓名：<input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"/><br/>
    <input type="submit" value="提交参数"/>
  </form>
  <h3>当方法返回String，实现forward请求转发</h3>
  <form method="post" action="forwardString">
    姓名：<input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"/><br/>
    <input type="submit" value="提交参数"/>
  </form>
  </body>
</html>
