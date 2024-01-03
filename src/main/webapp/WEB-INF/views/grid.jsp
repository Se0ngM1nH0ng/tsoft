<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Boot JSP Example</title>
    <!-- CSS 파일 추가 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/tui-grid.css">
    <!-- JavaScript 파일 추가 -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/tui-grid.js"></script>
</head>
<body>
<h1>Toastui.Grid</h1>
<div id="grid"></div>

<script>
    const gridData = [
        {
            id: '10012',
            city: 'Seoul',
            country: 'South Korea'
        },
        {
            id: '10013',
            city: 'Tokyo',
            country: 'Japan'
        },
        {
            id: '10014',
            city: 'London',
            country: 'England'
        },
        {
            id: '10015',
            city: 'Ljubljana',
            country: 'Slovenia'
        },
        {
            id: '10016',
            city: 'Reykjavik',
            country: 'Iceland'
        }
    ];
    const grid = new tui.Grid({
        el: document.getElementById('grid'),
        data: '',
        scrollX: false,
        scrollY: false,
        columns: [
            {
                header: 'Name',
                name: 'id'
            },
            {
                header: 'Artist',
                city: 'artist',
                editor: 'text'
            },
            {
                header: 'Type',
                country: 'type'
            }
        ]
    });
    grid.resetData(gridData);
</script>
</body>
</html>
