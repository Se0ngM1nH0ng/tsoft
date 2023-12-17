<%--
  Created by IntelliJ IDEA.
  User: HongSeongMin
  Date: 2023-12-03
  Time: 오후 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 성공시</title>
</head>
<body>
<h1>로그인에 성공 하셨습니다.</h1>
<div>

    <button class="ButtonMode" name="ADMIN" onclick="buttonClick(this.name)">관리자 모드로 전환</button>
    <button class="ButtonMode" name="MANAGER" onclick="buttonClick(this.name)">매니저 모드로 전환</button>
    <button class="ButtonMode" name="USER" onclick="buttonClick(this.name)">사용자 모드로 전환</button>
</div>
<br> <br>
<a href="/user">유저 페이지로 이동</a> <br> <br>
<a href="/manager">매니저 페이지로 이동</a> <br> <br>
<a href="/admin">관리자 페이지로 이동</a> <br> <br>

<script>
    function buttonClick(buttonName){
        const roleData = {
            role: buttonName // 버튼의 name 속성 값을 사용자의 역할로 지정
        };

        // 서버로 데이터를 전송하는 fetch 함수
        fetch('/changeRole', {
            method : 'POST',
            headers : {
                'Content-Type': 'application/json' // JSON 형식으로 전달한다.
            },
            body : JSON.stringify(roleData) // JSON 데이터를 문자열로 변환하여 body에 담아 전송
        })
            .then(response => response.text()) // 서버로부터 받은 응답을 텍스트로 변환
            .then(data => {
                if (data === 'success') {
                    alert('변경되었습니다 ! 다시 로그인 해주세요 !')
                    window.location.href = '/logout'; // 성공적인 응답을 받았을 때 로그아웃 URL로 이동

                }
            })
            .catch(error => console.error('Error', error)); // 요청 과정에서 발생한 에러 처리

    }
</script>

</body>
</html>
