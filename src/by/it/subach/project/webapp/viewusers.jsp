<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p><H3>Пользователи</H3></p>
	<table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Login</th>
          <th scope="col">Email</th>
          <th scope="col">Role</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${users}" var="user" varStatus="userCount">
        <tr>
          <th>${userCount.count}</th>
          <td>${user.login}</td>
          <td>${user.email}</td>
          <c:forEach items="${roles}" var="role">
          		<c:if test="${user.role_id==role.id}">
          		<td>${role.role}</td>
          		</c:if>
          </c:forEach>

        </tr>
        </c:forEach>
      </tbody>
    </table>

</div>
</body>
</html>