<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/3/27/0027
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>首页</h1>
<span>${password}</span>
<span>${username}</span>

<p>
    <a href="${pageContext.request.contextPath}/user/goOut">注销</a>
</p>

</body>
</html>


