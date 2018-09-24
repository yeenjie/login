<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2018/9/6
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://how2j.cn/study/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
<html>
<head>
    <title>login</title>
</head>
<body id="body">
<div id="login-window">
    <h2>个人登陆</h2>
    <form  id="form" action="" method="post">
        账号：<input id="name" type="text" name="name"></br>
        密码：<input id="password" type="password" name="password"><br>
        验证码：<input id="logcheck" type="text" name="name" size="5" maxlength="4"><a href="login.html"><img border="0" src="logcheck"></a><br>
        <input id="login" type="button" value="登陆">
        <a href="register.jsp"><input type="button" value="注册"></a>
    </form>
    <div id="checkResult"></div>
</div>
</body>

<script>
    $(function () {
        $("#login").click(function(){
            // alert("触发！");
            // var data = $("#form").serialize();
            // var url = "/loginServlet?"+data;
            // alert(url);
            // $("#checkResult").load(url);

            var name =$("#name").val();
            var password = $("#password").val();
            var logcheck = $("#logcheck").val();
            $.ajax({
                type:"post",
                data:{"name":name,"password":password,"logcheck":logcheck},
                dataType:"html",
                url:"/loginServlet",
                async:false,
                success:function(data){
                    //     这一部分做业务处理，data就是你后台返回的html代码片。
                    // 你可以把它插入到相应的标签里进行显示。
                    if(data=="pageUser") {
                        window.location.href="/pageUser.jsp";
                    }else if(data=="listUsers"){
                        window.location.href="/listUsers";
                    }else{
                        alert(data);
                        window.location.href="/login.html";
                    }
                }
            });
        });

    });
</script>
</html>
</html>
