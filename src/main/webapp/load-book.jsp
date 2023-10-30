<%--
  Created by IntelliJ IDEA.
  User: T490s Touch
  Date: 23.10.2023
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>File Upload</title>
</head>
<body>
<div>
    <h3> Choose File to Upload in Server </h3>
    <form action="load-book" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="upload"/>
    </form>
</div>
</body>
</html>
