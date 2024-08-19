<%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-19(월)
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성</title>
</head>
<body>
<%
    String loginId = (String)session.getAttribute("loginId");
    if(loginId == null) {

    }
%>
<form action="<%=request.getContextPath()%>/board.do?action=write" method="post">
    제목: <input type="text" placeholder="제목을 입력하세요." id="title" name="title"/><br>
    작성자: <%=loginId%>
    내용: <textarea placeholder="내용을 입력하세요" name="content"></textarea><br>
    <input type="submit" value="작성완료">
</form>
</body>
</html>
