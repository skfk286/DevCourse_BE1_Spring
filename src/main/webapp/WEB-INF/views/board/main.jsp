<%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-13(화)
  Time: 오후 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판 메인 화면</title>
</head>
<body>
    <a href="<%=request.getContextPath()%>/board.do?action=list">[목록보기]</a>
    <a href="<%=request.getContextPath()%>/board.do?action=writeForm">[작성하러가기]</a>
</body>
</html>
