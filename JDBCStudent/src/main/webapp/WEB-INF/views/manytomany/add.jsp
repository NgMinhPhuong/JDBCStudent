<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/19/2024
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/students">
        ID:<input name="id"><br>
        Name:<input name="name"><br>
        Email:<input name="email"><br>
        Address:<input name="address"><br>
        <input type="hidden" name="action" value="add">
        <input type="submit">
    </form>
</body>
</html>
