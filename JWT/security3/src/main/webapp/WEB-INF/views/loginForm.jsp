<%--
  Created by IntelliJ IDEA.
  User: HongSeongMin
  Date: 2023-12-03
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<h1>로그인 페이지</h1>

<form action="/login" method="post">
    <input type="text" name="username" placeholder="Username"/><br>
    <input type="password" name="password" placeholder="Password"/><br>
    <input type="submit" value="로그인">
</form>

<hr>

<a href="/joinForm">회원가입</a>

</body>
</html>
