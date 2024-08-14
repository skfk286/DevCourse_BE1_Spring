<%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-14(수)
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>당신이 들고온 쿠키는 다음과 같습니다.</h3>
<%
  Cookie[] cookies = request.getCookies();
  if(cookies != null) {
     for (Cookie cookie : cookies) {
%>
  쿠키이름:<%=cookie.getName()%><br>
  쿠키 값 :<%=cookie.getValue()%><br>
  <hr>
<% }
  } else {
    response.getWriter().println("당신이 들고온 쿠키가 없습니다.<br>");
  }
%>
</body>
</html>
