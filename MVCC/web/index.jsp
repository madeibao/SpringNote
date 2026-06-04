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
  <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
  <script type="text/javascript">
    $(function () {
      $("#btn1").click(function () {
        $.ajax({
          url: "user/returnVoid-ajax.do",
          data: {
            name: "张三",
            age: 22,
          },
          type: "POST",
          dataType: "json",
          success: function (resp) {//返回的是json类型的字符串  {"name":"张三","age":22}
            alert(resp.name);
          }
        })
      })

      //发起ajax请求，处理器方法中加入@ResponseBody注解，
      //使用springMVC的注解驱动把Java对象转换为json字符串
      $("#btn2").click(function () {
        $.ajax({
          url: "user/returnStudentJson.do",
          type: "POST",
          dataType: "json",
          success: function (resp) {//返回的是json类型的字符串
            alert(resp.name);
          }
        })
      })

      $("#btn3").click(function () {
        $.ajax({
          url: "user/returnListJson.do",
          type: "POST",
          dataType: "json",
          success: function (resp) {//返回的是json类型的字符串数组
            //[{"name":"鸡脖","age":28},{"name":"鸭掌","age":18}]
            $.each(resp, function (i, n) {
              alert("jQuery循环" + i + "  " + n.name + "   " + n.age);
            })

          }
        })
      })

      $("#btn4").click(function () {
        $.ajax({
          url: "user/returnStringData.do",
          type: "POST",
          dataType: "text",
          success: function (resp) {//返回的是String字符串
            alert(resp);
          }
        })
      })
    })
  </script>
</head>
<body>
<h3>处理器方法返回String，用来表示视图名称</h3>
<form method="post" action="user/returnString-view.do">
  姓名：<input type="text" name="name"/><br/>
  年龄：<input type="text" name="age"/><br/>
  <input type="submit" value="提交参数"/>
</form>
<br/>
<button id="btn1">发起ajax请求</button><br/>
<button id="btn2">发起ajax请求，使用springMVC注解驱动，返回对象</button><br/>
<button id="btn3">发起ajax请求，使用springMVC注解驱动，返回list集合</button><br/>
<button id="btn4">发起ajax请求，使用springMVC注解驱动，返回String数据</button><br/>
</body>
</html>
