<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>

		<h1>회원가입</h1>
		<form action="signup"  method="POST">
		아이디 <input type="text" name="mid" required> 
		<button type="button" id="midCheck">중복확인</button>
		<span id="messageArea"></span><br>
		비밀번호 <input type="password" name="mpw" required><br>
		닉네임 <input type="text" name="mname" placeholder ="이름은 입력하지않아도 괜찮습니다."> <br>
		<input type ="submit" value="회원가입">
		</form>

<script>
$('#midCheck').on('click', function() {
    const mid = $('input[name="mid"]').val();
    const data = { mid: mid };

// jQuery ajax 방식
  
  $.ajax({
        url: 'signupCheck',
        type: 'POST',
        data : data,
        dataType: "json",
        success: function(result) {
           	if(result === "true"){
           		   $('#messageArea').text("가입 가능한 아이디입니다.");
           	}else {
                $('#messageArea').text("이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.");
            }
        },
        error: function(error) {
            console.log("로그 : error 발생 ");
        }
    });
});
</script>

</body>
</html>