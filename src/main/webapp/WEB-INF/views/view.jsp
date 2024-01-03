<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Boot JSP Example</title>
    <!-- CSS 파일 추가 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/toastui-editor.min.css">
    <!-- JavaScript 파일 추가 -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/toastui-editor-all.min.js"></script>
</head>
<body>
<h1 onclick="openPopup();return false;">View</h1>
<div id="view" ></div>
</body>
<script>
    function openPopup() {
        var windowFeatures = 'width=800,height=600,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no';
        window.open(
            "http://localhost:9090/page/popup", '_blank', windowFeatures
        )
    }
</script>
</html>