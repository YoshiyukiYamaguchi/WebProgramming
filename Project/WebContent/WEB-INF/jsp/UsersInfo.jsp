<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/UsersInfo.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
 <script src="js/bootstrap.min.js"></script>
<head>


<meta charset="UTF-8">
<title>Info</title>
</head>
<body>
<c:if test = '${userInfo == null }'><%response.sendRedirect("LogoutServlet"); %></c:if>
<h2>${userInfo.name}さん</h2><div><a class="btn btn-primary" href ="LogoutServlet">ログアウト</a></div>

<h1>ユーザ情報詳細参照</h1><br>
<form method = "get" action = "UserInfoServlet">
<table class="table table-striped">
               <thead>
                 <tr>
                   <th>ログインID</th>
                   <th>ユーザ名</th>
                   <th>生年月日</th>
                   <th>登録日時</th>
                   <th>更新日時</th>
                   <th></th>
                 </tr>
               </thead>
               <tbody>

                   <tr>
                     <td>${user.loginId}</td>
                     <td>${user.name}</td>
                     <td>${user.birthDate}</td>
                     <td>${user.createDate}</td>
                     <td>${user.updateDate}</td>
                     </tr>
                     </tbody>

                     </table>
 <div class = "div1" ><a class="btn btn-primary" href ="LoginListServlet">戻る</a></div>

</form>
</body>
</html>