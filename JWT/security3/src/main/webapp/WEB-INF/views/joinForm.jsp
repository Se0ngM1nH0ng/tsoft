<%--
  Created by IntelliJ IDEA.
  User: HongSeongMin
  Date: 2023-12-03
  Time: 오후 3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1>회원가입 입니다.</h1>

<form action="join" method="post">
    <input type="text" name="mId" placeholder="Username"/><br>
    <input type="password" name="mPw" placeholder="Password"/><br>
    <input type="text" name="mName" placeholder="YourName"/><br>
    <input type="submit" value="회원가입">
</form>
</body>
</html>
