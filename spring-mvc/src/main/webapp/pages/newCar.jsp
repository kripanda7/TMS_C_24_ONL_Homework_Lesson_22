<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Car</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div align="center">
    <h2>New Car</h2>
    <form:form action="save" method="post" modelAttribute="car">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><form:input path="price" /></td>
                <td><form:errors path="price" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
