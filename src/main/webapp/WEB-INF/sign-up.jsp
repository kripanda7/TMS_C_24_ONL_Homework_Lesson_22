<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css" >
    <title>Sign Up</title>
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
