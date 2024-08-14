<%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-14(수)
  Time: 오전 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성 성공</title>
</head>
<body>
<!--
글 쓰기 완료입니다<br>
<a href="<%=request.getContextPath()%>/board.do?action=list">[목록으로]</a>
-->

<script> <!-- 자바스크립트 단에서 처리 가능 -->
    alert('글 작성이 완료되었습니다.')
    location.href="<%=request.getContextPath()%>/board.do?action=list";
</script>
</body>
</html>
