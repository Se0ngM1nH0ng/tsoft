<%--
  Created by IntelliJ IDEA.
  User: 개발
  Date: 2023-11-30
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>첫 페이지</title>
</head>
<body>
<h1>🌟 로그인 🌟</h1>
<form action="/loginCheck" method="POST">
    ID <input type="text" name="mid" required> <br>
    PW <input type="password" name ="mpw" required> <br>
    <input type="submit" value="로그인">
</form>
</body>
</html>
