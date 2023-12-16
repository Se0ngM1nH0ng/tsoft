<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입 페이지 입니다.</h1>
<table border="1">
    <tr>
        <td>
            <form action="signup" method="POST">
                 아이디  &nbsp <input type="text" name="mid" required> <br>
                비밀번호 <input type="password" name="mpw" required> <br>
                <input type="submit" value="회원가입 완료">
            </form>
        </td>
    </tr>
</table>
<br>
<a href = "main">메인으로 돌아가기</a>
</body>
</html>