<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--↑これは多分文字化け防止の記述 -->
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
<link rel="stylesheet" href="css/Login.css">
<meta charset="UTF-8">
<title>Login</title>

</head>
<body>
<br>
<c:if test = "${Msg != null}">
${Msg}</c:if>
<br>
<br>
<br>
<br>
<h1> ログイン画面 </h1>
<br>
<div class = "div5"><c:if test="${errMsg != null}" >
${errMsg}
</c:if></div>
<br>
<br>
<form method="post" action = "LoginServlet">
<c:if test = '${userInfo != null }'><%response.sendRedirect("LoginListServlet"); %></c:if>
ログインID <input type = "text" name = "loginId"><br>
<br>
パスワード <input type = "password" name = "password"><br>
<br>
<br>
<div class = "div1"> <input type = "submit" class="btn btn-primary" value = "ログイン"></div>
</form>


</body>
</html>