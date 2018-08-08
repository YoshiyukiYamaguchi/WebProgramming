<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>
<link href="css/bootstrap.min.css" rel="stylesheet">
 <script src="js/bootstrap.min.js"></script>
<head>
<link rel="stylesheet" href="css/Users.css">

<meta charset="UTF-8">
<title>Users</title>
</head>
<body>

<form method = "post" action = "LoginListServlet"><div class = "div1" >${userInfo.name}さん</div></form>
<c:if test = '${userInfo == null }'><%response.sendRedirect("LogoutServlet"); %></c:if>
<div class = "div2"><a class="btn btn-primary" href ="LogoutServlet">ログアウト</a></div>
<h1> ユーザー覧   </h1>

<c:if test = '${userInfo.loginId == "admin"}'><div class = "ABC" ><a class="btn btn-primary" href ="NewUsersServlet">新規登録</a><br></div></c:if>
<form method = "post" action = "http://localhost:8080/Example/LoginListServlet">
ログインID : <input type = "text" name = "loginId"><br><br>

ユーザー名：<input type = "text" name = "name"><br><br>

生年月日：<input type = "date" name = "birthDate"> ～ <input type = "date" name = "date"><br>

<P><input type = "submit" value  = "検索"><br>
                 <div class="table-responsive">
             <table class="table table-striped">
               <thead>
                 <tr>
                   <th>ログインID</th>
                   <th>ユーザ名</th>
                   <th>生年月日</th>
                   <th></th>
                 </tr>
               </thead>
               <tbody>

 		<c:forEach var = "user" items = "${userList}">
                   <tr>
             <c:if test = '${user.loginId != "admin"}'><td>${user.loginId}</td></c:if>
             <c:if test = '${user.loginId != "admin"}'><td>${user.name}</td></c:if>
             <c:if test = '${user.loginId != "admin"}'><td>${user.birthDate}</td></c:if>
                     <td>
<c:if test = '${user.loginId != "admin" }'><a class="btn btn-primary" href="UsersInfoServlet?id=${user.id }">詳細</a></c:if>
<c:if test = '${userInfo.loginId.equals(user.loginId) || userInfo.loginId == "admin"}'><c:if test = '${user.loginId != "admin" }'><a class="btn btn-success" href="UsersUpdateServlet?id=${user.id }">更新</a></c:if></c:if>
<c:if test = '${userInfo.loginId == "admin"}'><c:if test = '${user.loginId != "admin" }'><a class="btn btn-danger" href ="UsersDeleteServlet?id=${user.id }">削除</a></c:if></c:if>
                     </td>
                   </tr>
                     </c:forEach>
             </table>
           </div>
           </form>




</body>
</html>