<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.dtos.PhongBan" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Add Phong Ban</title>
</head>
<body>

<h1>Quản lý Phòng Ban</h1>

<form action="../phongban" method="post">
  <label for="tenPhongBan">Phòng ban:</label>
  <input type="text" name="tenPhongBan" required id="tenPhongBan"/>
  <input type="hidden" name="action" value="add"/>
  <input type="submit" value="Insert"/>
  <input type="reset" value="Clear"/>
</form>

<%
  List<PhongBan> list_pb = (List<PhongBan>) session.getAttribute("phongbans");

  if (list_pb == null || list_pb.isEmpty()) {
    out.println("<p><strong>Chưa có dữ liệu</strong></p>");
  } else {
    out.println("<h2>Danh sách phòng ban:</h2>");
    out.println("<table border='1' cellpadding='5' cellspacing='0'>");
    out.println("<tr><th>Tên phòng ban</th><th>Hành động</th></tr>");

    for (PhongBan phongBan : list_pb) {
      out.println("<tr>");
      out.println("<td>" + phongBan.getTenPhongBan() + "</td>");
      out.println("<td>");
      out.println("<form action='../phongban' method='post' style='display:inline;'>");
      out.println("<input type='hidden' name='id' value='" + phongBan.getMaPhongBan() + "'/>");
      out.println("<input type='text' name='tenPhongBan' value='" + phongBan.getTenPhongBan() + "' required style='width: 200px;'/>");
      out.println("<input type='hidden' name='action' value='update'/>");
      out.println("<input type='submit' value='Update'/>");
      out.println("</form> ");

      out.println("<form action='../phongban' method='post' style='display:inline;'>");
      out.println("<input type='hidden' name='id' value='" + phongBan.getMaPhongBan() + "'/>");
      out.println("<input type='hidden' name='action' value='delete'/>");
      out.println("<input type='submit' value='Delete' onclick=\"return confirm('Bạn có chắc chắn muốn xóa?');\"/>");
      out.println("</form>");
      out.println("</td>");
      out.println("</tr>");
    }
    out.println("</table>");
  }
%>

</body>
</html>
