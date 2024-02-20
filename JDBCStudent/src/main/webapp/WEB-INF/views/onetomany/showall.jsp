<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/20/2024
  Time: 1:54 PM
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
            <td>School</td>
            <td>Teacher</td>
        </tr>
        <c:forEach var="i" items="${lists}">
            <tr>
                <td>${i.getName()}</td>
                <td>
                    <c:forEach var="ii" items="${i.getTeacherList()}">
                        <span>${ii.getName()}</span>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
