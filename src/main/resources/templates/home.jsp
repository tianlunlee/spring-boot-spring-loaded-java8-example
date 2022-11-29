<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <div th:fragment="content">
        <h1>Welcome</h1>

        <p> <a th:href="@{/login.jsp}">Log In</a></p>
        <p> <a th:href="@{/signup.jsp}">Register</a></p>
    </div>
</body>
</html>
