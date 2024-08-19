<%@ page import="com.devcourse.ycjung.day_0819.my_board.model.MyBoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-19(월)
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 상세보기</title>
</head>
<body>
<%
    String loginId = (String)session.getAttribute("loginId");
    MyBoardDTO boardDTO = (MyBoardDTO)request.getAttribute("boardDTO");
    String writer = boardDTO.getWriter();
%>
<form action="<%=request.getContextPath()%>/myBoard.do?action=modify" method="post">
    <table border="1">
        <tr>
            <td>글 번호 : </td>
            <%if(loginId != null && loginId.equals(writer)) {%>
                <td><input type="text" value="<%=boardDTO.getNo()%>" name="no" readonly></td>
            <%} else {%>
                <td><%=boardDTO.getNo()%></td>
            <%}%>
        </tr>
        <tr>
            <td>글 제목 : </td>
            <%if(loginId != null && loginId.equals(writer)) {%>
                <td><input type="text" value="<%=boardDTO.getTitle()%>" name="title"></td>
            <%} else {%>
                <td><%=boardDTO.getTitle()%></td>
            <%}%>
        </tr>
        <tr>
            <td>글 작성자 : </td>
            <td><%=boardDTO.getWriter()%></td>
        </tr>
        <tr>
            <td>글 작성일시 : </td>
            <td><%=writer%></td>
        </tr>
        <tr>
            <td>글 조회수 : </td>
            <td><%=boardDTO.getReadCount()%></td>
        </tr>
        <tr>
            <td>글 내용 : </td>
            <%if(loginId != null && loginId.equals(writer)) {%>
                <td><input type="text" value="<%=boardDTO.getContent()%>" name="content"></td>
            <%} else {%>
                <td><%=boardDTO.getContent()%></td>
            <%}%>
        </tr>
    </table>
    <%if(loginId != null && loginId.equals(writer)) {%>
        <input type="submit" value="수정하기">
    <%} %>

</form>

<a href="<%=request.getContextPath()%>/myMain.do">[메인화면으로]</a>

<% if(loginId != null && loginId.equals(writer)) { %>
        <a href="<%=request.getContextPath()%>/myBoard.do?action=remove&no=<%=boardDTO.getNo()%>">[삭제하기]</a>
<% } %>

</body>
</html>
