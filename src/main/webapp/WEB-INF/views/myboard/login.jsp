<%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-19(월)
  Time: 오전 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 화면</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/myUser.do" method="post">
        ID : <input type="text" name="userid"><br>
        PW : <input type="password" name="userpw"><br>
        <input type="submit" value="로그인">
    </form>
</body>
</html>
