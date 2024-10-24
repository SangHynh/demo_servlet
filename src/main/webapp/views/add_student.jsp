<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/15/2024
  Time: 7:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <form action="../controller" method="get">
        <input type="hidden" name="action" value="add"/>
        Full name:<input name="fullname"/><br/>
        Email:<input type="email" name="email"/><br/>
        <input type="submit" value="Insert">
        <input type="reset" value="Clear"/>

    </form>
</body>
</html>
