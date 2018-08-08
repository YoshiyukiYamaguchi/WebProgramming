<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<link rel = "stylesheet" href = "css/UsersUpdate.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
 <script src="js/bootstrap.min.js"></script>

<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<c:if test = '${userInfo == null }'><%response.sendRedirect("LogoutServlet"); %></c:if>
<h2>${userInfo.name}さん</h2><form method = "get" action = "LogoutServlet"><div class = "div2"><a class="btn btn-primary" href ="LogoutServlet">ログアウト</a></div></form>
<h1>ユーザ情報更新</h1><br><br>
<form method = "post" action = "UsersUpdateServlet">
<div class = "div5"><c:if test="${errMsg != null}" >
${errMsg}
</c:if></div>

<input type ="hidden" name = "id" value="${user.id}">

ログインID: ${user.loginId}<br><br>

パスワード: <br><input type ="text" name = "password"><br><br>

パスワード(確認):<br><input type = "text" name = "re_password"><br><br>

ユーザ名：
    <p><input type="text" value = "${user.name}"  name = "name"></p>

生年月日：
    <p><input type="text" value="${user.birthDate}" name = "birthDate"></p>


<input type = "submit" value = "更新"><br><br>
<div class = "div1" ><a class="btn btn-primary" href ="LoginListServlet">戻る</a><br></div>
</form>
</body>
</html>