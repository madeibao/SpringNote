<%--
  Created by IntelliJ IDEA.
  User: 郝龙飞
  Date: 2021/11/6
  Time: 8:48
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
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            loadStudents();
            $("button").click(function () {
                    loadStudents();//起到刷新页面学生信息的作用
                }
            )

            function loadStudents() {
                $.ajax({
                    url: "student/queryStudents",
                    dataType: "json",
                    type: "GET",
                    success: function (resp) {
                        //在加数据之前先把之前的数据清除掉
                        $("#stu").html("");

                        $.each(resp, function (i, n) {//i是下标，n表示集合中的每一个json对象
                            $("#stu").append("<tr>")
                                .append("<td>").append(n.id).append("</td>")
                                .append("<td>").append(n.name).append("</td>")
                                .append("<td>").append(n.age).append("</td>")
                                .append("</tr>");
                        })
                    }

                })
            }
        })
    </script>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    </thead>
    <tbody id="stu">
    </tbody>
</table>
<br/>
<button>查询学生信息</button>
</body>
</html>
