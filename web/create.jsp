<%--
  Created by IntelliJ IDEA.
  User: -1-
  Date: 18.02.2019
  Time: 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create product</title>
</head>
<body>
<h3>Новый пользователь</h3>
<form method="post">
    <label>Id</label><br>
    <input name="id"/><br><br>
    <label>Имя</label><br>
    <input name="firstname"/><br><br>
    <label>Фамилия</label><br>
    <input name="lastname"/><br><br>
    <label>Возраст</label><br>
    <input name="age" type="number" min="1" /><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
