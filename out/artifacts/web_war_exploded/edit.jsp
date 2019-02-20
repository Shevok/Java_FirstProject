<%--
  Created by IntelliJ IDEA.
  User: -1-
  Date: 18.02.2019
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit product</title>
</head>
<body>
<c var="user" items="${user}">
<h3>Edit product</h3>
<form method="post">
    <label>Id</label><br>
    <input  value="${user.id}" name="id" /><br><br>
    <label>Имя</label><br>
    <input  name="firstname" value="${user.firstname}" /><br><br>
    <label>Фамилия</label><br>
    <input name="lastname" value="${user.lastname}" /><br><br>
    <label>Возраст</label><br>
    <input name="age" value="${user.age}" type="number" min="1" /><br><br>
    <input type="submit" value="Send" />
</form>
    </c>
</body>
</html>
