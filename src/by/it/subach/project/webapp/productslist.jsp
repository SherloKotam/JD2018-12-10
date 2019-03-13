<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p><H3>${categoryName}</H3></p>
	<table class="table">
      <thead>
        <tr>
          <th scope="col">NAME</th>
          <th scope="col">PRICE</th>
          <th scope="col">DESCRIPTION</th>
          <th scope="col">CATEGORY</th>
          <th scope="col"></th>

        </tr>
      </thead>
      <tbody>
        <c:forEach items="${products}" var="product">
        <tr>
          <th>${product.name}</th>
          <td>${product.price}</td>
          <td>${product.description}</td>
		  <td>${categoryName}</td>
		  <td>
			  <form class="form-horizontal" action="do?command=Order&id=${product.id}" method="post">
		  	  <!-- Button -->
                <div class="col-md-4">
                  <button id="buy" name="buy" class="btn btn-primary">Купить</button>
                </div>
                </form>
          </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>

</div>
</body>
</html>