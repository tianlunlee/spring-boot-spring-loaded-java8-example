<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Logged in</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <div style="padding: 10px;">

        <div>
            <strong>Logged in.</strong>
        </div>

        <div th:replace="${view} :: content">
            Content
        </div>
    </div>
</body>
</html>
