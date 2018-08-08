<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel = "stylesheet" href = "css/NewUsers.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
 <script src="js/bootstrap.min.js"></script>
<head>
<meta charset="UTF-8">
<title>NewUsers</title>
</head>
<body>

<h3>${userInfo.name}さん</h3>
<div><a class="btn btn primary" href ="LogoutServlet">ログアウト</a></div>
<h1>ユーザ新規登録</h1>
<form method = "post" action = "NewUsersServlet">
<c:if test = '${userInfo == null }'><%response.sendRedirect("LogoutServlet"); %></c:if>
<div class = "div5"><c:if test="${errMsg != null}" >
${errMsg}</c:if></div>
<div class = "div6"><c:if test="${errmSg != null}" >
${errmSg}</c:if></div>
<br>
ログインID：<input type="text" value = "${ub.loginId}" name="loginId"><br><br>
パスワード：<input type="text" value = "${ub.password }" name="password"><br><br>
パスワード(確認)：<input type="text" value = "${ub.password }"name="re_password"><br><br>
ユーザ名：<input type="text" value = "${ub.name}" name = "name"><br><br>
生年月日：<input type="text" value = "${ub.birthDate }" name="birth_date"><br><br>
<input type="submit" value="登録"><br><br>
<div class = "div1"> <a class="btn btn-primary" href ="LoginListServlet">戻る</a></div>
</form>










</body>
</html>