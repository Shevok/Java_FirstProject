<%-- Created by IntelliJ IDEA. --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Users</title>
</head>
<body>
<h2>Users List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
  <tr><th>Id</th><th>Name</th><th>Lastname</th><th>Age</th>
    <th>
  <form method="post" action='<c:url value="/searchResult" />' style="display:inline;">
    <input name="lastname" value="Введите фамилию">
    <input type="submit" value="Search">
  </form>
    </th>
  </tr>
  <c:forEach var="user" items="${users}">
    <tr><td>${user.id}</td>
        <td>${user.firstname}</td>
        <td>${user.lastname}</td>
        <td>${user.age}</td>
      <td>
        <a href='<c:url value="/edit?id=${user.id}" />'>Edit</a> |
        <form method="post" action='<c:url value="/deleteServlet" />' style="display:inline;">
          <input type="hidden" name="id" value="${user.id}">
          <input type="submit" value="Delete">
        </form>
      </td></tr>
  </c:forEach>
</table>
</body>
</html>
