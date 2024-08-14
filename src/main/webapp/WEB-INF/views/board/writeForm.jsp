<%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-14(수)
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/board.do?action=write" method="post">
    제목: <input type="text" placeholder="제목을 입력하세요." id="title" name="tttt"/><br>
    작성자: <input type="text" name="wwww" placeholder="작성자를 적으세요."><br>
    내용: <textarea placeholder="내용을 입력하세요" name="cccc"></textarea><br>
    <input type="submit" value="작성완료">
</form>
</body>
</html>
