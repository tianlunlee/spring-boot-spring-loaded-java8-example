<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Sign Up</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<div th:fragment="content">

    <%--    use this for username already in use--%>
    <%--    <div th:if="${param.error}">--%>
    <%--        Invalid username and password.--%>
    <%--    </div>--%>
    <div th:if="${param.logout}">
        You have been logged out.
    </div>

    <form th:action="@{/signup}" method="post">
        <div><label> First Name : <input type="text" name="firstname"/> </label></div>
        <div><label> Last Name: <input type="text" name="lastname"/> </label></div>
        <div><label> Username: <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><label> Address: <input type="text" name="address"/> </label></div>
        <div><label> Email: <input type="email" name="email"/> </label></div>
        <div><label> Phone: <input type="number" name="phone"/> </label></div>
        <div><input type="submit" value="Register"/></div>

    </form>


</div>
</body>
</html>
