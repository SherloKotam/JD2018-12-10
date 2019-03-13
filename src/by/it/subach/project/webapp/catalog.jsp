<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<p><h3>Catalog</h3></p>

	<c:forEach items="${categories}" var="category">
		<c:url value="/do?command=ProductsList" var="url">
		<c:param name="id" value="${category.id}"/>
		</c:url>
		<a href="${url}">${category.name}</a><br>
	</c:forEach>

</div>
</body>
</html>