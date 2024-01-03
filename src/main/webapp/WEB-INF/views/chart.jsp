<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Boot JSP Example</title>
    <!-- CSS 파일 추가 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/toastui-chart.min.css">
    <!-- JavaScript 파일 추가 -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/toastui-chart.min.js"></script>
</head>
<body>
<h1>Toastui.Chart</h1>
<div id="chart"></div>
</body>
<script>
    const el = document.getElementById('chart');
    const data = {
        categories: ['Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        series: [
            {
                name: 'Budget',
                data: [5000, 3000, 5000, 7000, 6000, 4000, 1000],
            },
            {
                name: 'Income',
                data: [8000, 4000, 7000, 2000, 6000, 3000, 5000],
            },
        ],
    };
    const options = {
        chart: { width: 700, height: 400 },
    };

    const chart = toastui.Chart.barChart({ el, data, options });
</script>
</html>