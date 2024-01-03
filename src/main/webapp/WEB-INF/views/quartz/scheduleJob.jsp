<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Schedule Job</title>
</head>
<body>

<h2>Schedule a Job</h2>

<form:form modelAttribute="jobForm" method="post" action="${pageContext.request.contextPath}/scheduleJob">
    <label for="jobName">Job Name:</label>
    <form:input path="jobName" id="jobName" required="true"/>

    <label for="jobGroup">Job Group:</label>
    <form:input path="jobGroup" id="jobGroup" required="true"/>

    <label for="cronExpression">Cron Expression:</label>
    <form:input path="cronExpression" id="cronExpression" required="true"/>

    <button type="submit">Schedule Job</button>
</form:form>

<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

</body>
</html>
