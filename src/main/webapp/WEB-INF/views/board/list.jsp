<%@ page import="java.util.List" %>
<%@ page import="com.devcourse.ycjung.day_0813.simple_board.model.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-13(화)
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
<%
    List<BoardDTO> bList = (List<BoardDTO>)request.getAttribute("bList");
    for (BoardDTO b : bList) {
%>
    <tr>
        <td><%=b.getNo()%></td>
        <td><%=b.getTitle()%></td>
        <td><%=b.getWriter()%></td>
        <td><%=b.getRegDate()%></td>
        <td><%=b.getReadCount()%></td>
        <td><%=b.getContent()%></td>
    </tr>
<%
    }
%>
</table>
</body>
</html>
