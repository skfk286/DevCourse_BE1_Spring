<%--
  Created by IntelliJ IDEA.
  User: ycjung
  Date: 2024-08-19(월)
  Time: 오전 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script>
        alert("<%=request.getAttribute("msg")%>");
        /*alert("<%=request.getAttribute("path")%>")*/
        location.href = "<%=request.getAttribute("path")%>";
    </script>
</body>
</html>
