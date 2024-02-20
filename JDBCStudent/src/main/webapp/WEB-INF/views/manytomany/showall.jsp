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

            <td>class</td>
            <td>teacher</td>
        </tr>
        <c:forEach var="i" items="${lists}">
            <tr>
                <td>${i.getName()}</td>
                <td>
                    <c:forEach var="ii" items="${i.getTeachers()}">
                        <span>${ii.getName()}</span>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
