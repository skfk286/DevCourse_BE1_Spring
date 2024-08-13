<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        h1{background-color: yellow;}
    </style>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%
    Random random = new Random();
    if(random.nextBoolean()) {
        response.getWriter().println("<h1>불이야!!!<h1>");
    }
%>
</body>
</html>