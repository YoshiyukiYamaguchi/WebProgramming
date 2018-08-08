<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("UTF-8");



    String name = request.getParameter("name");
    String gender = request.getParameter("gender");



    %>
<!DOCTYPE html>
<html>
<head>
<meta charset = "UTF-8">
<title>入力内容表示</title>
</head>
<body>
<p>名前:${param.name}</p>
<p>性別:${param.gender}</p>
</body>
</html>