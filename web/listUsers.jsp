<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2018/9/9
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>list</title>
</head>
<body>
<h1>管理员界面</h1>
<table align="center" border="1" cellpadding="0">
    <tr>
        <td>账号</td>
        <td>密码</td>
        <td>删除</td>
        <td>增加权限</td>>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="st">
        <tr>
            <td>${user.getName()}</td>
            <td>${user.getPassword()}</td>
            <td><a href="deleteUser?id=${user.getId()}">删除</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
