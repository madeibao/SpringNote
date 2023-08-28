<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<marquee>--%>
<p style="font-size: 100px" align="center">Hello JSP!!</p>
<marquee direction="right">
    <img src="${pageContext.servletContext.contextPath}/doge.gif">
</marquee>
</body>
</html>
