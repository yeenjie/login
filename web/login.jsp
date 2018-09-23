<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2018/9/6
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <div>
        个人登陆

        <form action="loginServlet" method="post">
            <input type="text" name="name"></br>
            <input type="text" name="password"><br>
            <input type="submit" value="登陆">
        </form>
            

    </div>
</body>
</html>
