<%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-14(수)
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="<%=request.getContextPath()%>/makeCookie">[쿠키 발급받으러 가기]</a><br>
    <a href="<%=request.getContextPath()%>/checkCookie">[쿠키 확인]</a><br>
    <%
        String loginId = (String)session.getAttribute("loginId");
        if(loginId == null) { // 로그인 안된 사용자는 로그인 링크 그대로 보여주고,
    %>
    <a href="<%=request.getContextPath()%>/user?action=login">[로그인 하러가기]</a><br>
    <%
        } else { // 이미 로그인이 되어있을 때,
    %>
        로그인된 사용자이시군요!<br>
        <b><%=loginId%> 님 반갑습니다!</b>
        <a href="<%=request.getContextPath()%>/user?action=logout">[로그아웃]</a>
    <%
        }
    %>
</body>
</html>
