<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2018/9/6
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://how2j.cn/study/jquery.min.js"></script>
<html>
<head>
    <title>login</title>
</head>
<body>
    <div>
        <h1>个人登陆</h1>
        <form  id="form" action="" method="post">
            <input type="text" name="name"></br>
            <input type="text" name="password"><br>
            <input id="login" type="submit" value="登陆">
            <a href="register.jsp"><input type="button" value="注册"></a>
        </form>
        <div id="checkResult"></div>
    </div>
</body>

<script>
    $(function () {
        $("#login").onclick(function(){
            alert("触发！")
            var data = $("#form").serialize();
            var url = "loginServlet"+data;
            htmlobj=$.ajax({url:url,async:false});
            $("#checkResult").html(htmlobj);
        });
    });
</script>
</html>
