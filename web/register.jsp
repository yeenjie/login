<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2018/9/7
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://how2j.cn/study/jquery.min.js"></script>
<link rel="stylesheet" href="./style/css/login.css">
<html>
<head>
    <title>注册</title>
</head>
<body>
<div id="login-window">
    <form id="form" action="/registerServlet" method="post">
        <h2>账号注册</h2>
        账号：<input id="name" type="text" name="name"><div id="info"></div>
        密码：<input id="password" type="password" name="password"><br>
        验证码：<input id="logcheck" type="text" name="name" size="5" maxlength="4"><a href="register.jsp"><img id="yanzhengma" border="0" src="logcheck"></a><br>
        <input id="register" type="button" value="注册">
        <a href="login.jsp"><input type="button" value="返回"></a>
    </form>
</div>
    <script>
        $(function () {
            $("#register").click(function(){
                var name =$("#name").val();
                var password =$("#password").val();
                var logcheck = $("#logcheck").val();
                $.ajax({
                    type:"post",
                    data:{"name":name,"password":password,"checkName":"0","logcheck":logcheck},
                    dataType:"html",
                    url:"/registerServlet",
                    async:false,
                    success:function(data){
                        //     这一部分做业务处理，data就是你后台返回的html代码片。
                        // 你可以把它插入到相应的标签里进行显示。

                        if(data=="succeed") {
                            alert("注册成功！");
                            window.location.href="/login.jsp";
                        }else if(data=="exist"){
                            alert("用户已存在！")
                            window.location.href="/register.jsp";
                        }else if(data=="fail"){
                            alert("用户加入数据库时出现错误！")
                            window.location.href="/register.jsp";
                        }else if(data=="checkfail"){
                            alert("验证码输出错误！");
                            window.location.href="/register.jsp";
                        }else{
                            alert("注册出现未知意外！")
                            window.location.href="/register.jsp";
                        }
                    }
                });
            });

            $("#name").keyup(function(){
                var name =$("#name").val();
                $.ajax({
                    type:"post",
                    data:{"name":name,"password":"none","checkName":"1"},
                    dataType:"html",
                    url:"/registerServlet",
                    async:false,
                    success:function(data){
                        //     这一部分做业务处理，data就是你后台返回的html代码片。
                        // 你可以把它插入到相应的标签里进行显示。
                        if(data=="exist"){
                            $("#info").html("<span style='color:red'>用户名已存在</span>");
                        }else{
                             $("#info").html("<span style='color:green'>恭喜可以注册</span>");
                        }
                    }
                });
            });

        });
    </script>

</body>
</html>
