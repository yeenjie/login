<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2018/9/7
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="/registerServlet" method="post">
        账号：<input type="text" name="name">
        密码：<input type="password" name="password">
        <input type="submit" value="注册">
    </form>

</body>
</html>
