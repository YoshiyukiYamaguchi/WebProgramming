<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/UsersDelete.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
 <script src="js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
<c:if test = '${userInfo == null }'><%response.sendRedirect("LogoutServlet"); %></c:if>
<form method = "post" action = "UsersDeleteServlet">
<c:if test = "${errMsg != null}">
${errMsg}
</c:if>
<input type ="hidden" name = "id" value="${user.id}">

<h2>${userInfo.name}さん</h2><a class="btn btn-primary" href ="LogoutServlet">ログアウト</a>
<h1>ユーザ削除確認</h1>
<div class = "div1">ログインID ${user.loginId}<br>を本当に削除してよろしいでしょうか。</div>
<br><br>
<input type = "submit" value = "OK">　　　　　　　　　<a class="btn btn-primary" href ="LoginListServlet">キャンセル</a>
</form>
</body>
</html>