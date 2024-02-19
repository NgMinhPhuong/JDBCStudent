<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/19/2024
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>email</td>
            <td>address</td>
        </tr>
        <c:forEach var="i" items="${students}">
            <tr>
                <td>${i.getId()}</td>
                <td>${i.getName()}</td>
                <td>${i.getEmail()}</td>
                <td>${i.getAddress()}</td>
            </tr>
        </c:forEach>
    </table>
<a href="/students?action=add">Create Student</a>
</body>
</html>
