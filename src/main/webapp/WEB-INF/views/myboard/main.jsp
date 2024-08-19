<%@ page import="com.devcourse.ycjung.day_0819.my_board.model.MyBoardDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-19(월)
  Time: 오전 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인화면</title>
</head>
<body>

<%
    String loginId = (String)session.getAttribute("loginId");
    if(loginId == null) {
%>
    <a href="<%=request.getContextPath()%>/myUser.do?action=login">로그인</a>
    <a href="#">회원가입</a>
<%
    } else {
%>
    <b><%=loginId%> 님 반갑습니다!</b>
    <a href="<%=request.getContextPath()%>/myUser.do?action=logout">로그아웃</a>
<%
    }
%>

<h3>---------------------------------------</h3>
<table border="1">
    <tr>
        <th>순번</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록 날짜</th>
        <th>조회수</th>
        <th>내용</th>
    </tr>
    <%
        List<MyBoardDTO> bList = (List<MyBoardDTO>)request.getAttribute("boardList");
        for (MyBoardDTO b : bList) {
            String content = b.getContent();
            if (content.length() > 10) {
                content = content.substring(0, 10) + "...";
            }
    %>
    <tr>
        <td><%=b.getNo()%></td>
        <td><a href="<%=request.getContextPath()%>/myBoard.do?action=view&no=<%=b.getNo()%>"><%=b.getTitle()%><a/></td>
        <td><%=b.getWriter()%></td>
        <td><%=b.getRegDate()%></td>
        <td><%=b.getReadCount()%></td>
        <td><%=content%></td>
    </tr>
    <%
        }
    %>
</table>
<h3>---------------------------------------</h3>
<a href="<%=request.getContextPath()%>/myBoard.do?action=write">[글쓰기]</a> <!-- 로그인 시에만 글 쓰기 가능 체크 -->
</body>
</html>
