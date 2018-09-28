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
    <link rel="stylesheet" href="./style/css/admin.css">
</head>
<body>
<h1 id="title">管理员界面</h1>
<table id="table" align="center" border="1" cellpadding="0">
    <tr>
        <td>账号</td>
        <td>密码</td>
        <td>权限</td>
        <td>删除</td>
        <td>降低权限</td>>
        <td>增加权限</td>>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="st">
        <tr>
            <td>${user.getName()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getAuthority()}</td>
            <td><a href="deleteUser?id=${user.getId()}">删除</a></td>
            <td><a href="changeRole?name=${user.getName()}&role=0">取消管理员</a> </td>
            <td><a href="changeRole?name=${user.getName()}&role=1">设置管理员</a> </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
