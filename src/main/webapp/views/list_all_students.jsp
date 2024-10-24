<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.dtos.Student" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/15/2024
  Time: 7:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List All Student</title>
</head>
<body>
    <%
        List<Student> students= (List<Student>) session.getAttribute("students");
        for (Student st: students) {
            out.println(st);
        }
    %>
</body>
</html>
