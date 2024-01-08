<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Car Manager</title>
</head>
<body>
<div>
    <h2>Car Manager</h2>
    <h3><a href="/spring/new">New Car</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${listCars}" var="car">
            <tr>
                <td>${car.id}</td>
                <td>${car.name}</td>
                <td>${car.price}</td>
                <td>
                    <a href="/spring/edit?id=${car.id}">Edit</a>

                    <a href="/spring/delete?id=${car.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>