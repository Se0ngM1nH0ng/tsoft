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
<h1>Toastui.Editor</h1>
<div id="editor"></div>
</body>
<script>
    const editor = new toastui.Editor({
        el: document.querySelector('#editor'),
        height: '600px',
        initialEditType: 'markdown',
        previewStyle: 'vertical'
    });
</script>
</html>