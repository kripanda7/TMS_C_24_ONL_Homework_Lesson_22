<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: T490s Touch
  Date: 08.11.2023
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <style>
        .requiredField {
            color: red
        }
    </style>
</head>
<body>
<h3>Please, sign up</h3>
<form action="/signUp" method="POST">
    <p>${title}</p>
    Login <input name="login" type="text" value=${login}><label class="requiredField">${loginRequired}</label><br>
    Password <input name="password" type="password" value=${password}><label
        class="requiredField">${passwordRequired}</label><br>
    Confirmed password <input name="confirmedPassword" type="password" value=${confirmedPassword}><label
        class="requiredField">${confirmedPasswordRequired}</label>
    <label>${diffPassword}</label><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
