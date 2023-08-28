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
    <script type="text/javascript" src="js/jquery3-6.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                alert("button click");
                $.ajax({
                    // url:"returnString-ajax.do",
                    url:"returnObjectArr-ajax.do",
                    data:{
                        name:"蔡文姬",
                        age:20,
                    },
                    type:"post",
                    dataType:"text",
                    success:function (resp){
                        //alert(resp.name+"  "+resp.age);
                        alert(resp)
                    }
                })
            })
        })
    </script>
</head>
<body>
<p>返回String</p>
<form action="test/returnString-view.do" method="post">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="提交参数">
</form>
<br/>
<button id="bta">发起Ajax请求</button>
</body>
</html>
