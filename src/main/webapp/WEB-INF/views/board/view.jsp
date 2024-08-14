<%@ page import="com.devcourse.ycjung.day_0813.simple_board.model.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-14(수)
  Time: 오전 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 상세화면</title>
</head>
<body>
    <%
        BoardDTO bbb = (BoardDTO)request.getAttribute("bbb");
    %>
    <form action="<%=request.getContextPath()%>/board.do?action=modify" method="post">

        <table border="1">
            <tr>
                <td>글 번호 : </td>
                <%--<td><%=bbb.getNo()%></td>--%>
                <td><input type="text" value="<%=bbb.getNo()%>" name="no" readonly></td>
            </tr>
            <tr>
                <td>글 제목 : </td>
                <%--<td><%=bbb.getTitle()%></td>--%>
                <td><input type="text" value="<%=bbb.getTitle()%>" name="title"></td>
            </tr>
            <tr>
                <td>글 작성자 : </td>
                <td><%=bbb.getWriter()%></td>
            </tr>
            <tr>
                <td>글 작성일시 : </td>
                <td><%=bbb.getRegDate()%></td>
            </tr>
            <tr>
                <td>글 조회수 : </td>
                <td><%=bbb.getReadCount()%></td>
            </tr>
            <tr>
                <td>글 내용 : </td>
                <%--<td><%=bbb.getContent()%></td>--%>
                <td><input type="text" value="<%=bbb.getContent()%>" name="content"></td>
            </tr>
        </table>
        <input type="submit" value="수정하기">
        <%--<a href="#">[수정하기]</a>--%>
    </form>
        <a href="<%=request.getContextPath()%>/board.do?action=list">[목록으로]</a>
</body>
</html>
