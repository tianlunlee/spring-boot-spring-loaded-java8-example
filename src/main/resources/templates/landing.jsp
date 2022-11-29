<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <div th:fragment="content">

        <h1>Welcome</h1>

        <h1 th:inline="text"></h1>
        <h1 th:inline="text"></h1>
        <h1 th:inline="text"></h1>

        <form th:action="@{/logout}" method="post">
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
</body>
</html>
