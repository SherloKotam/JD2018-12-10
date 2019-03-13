<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<h3>Admin panel</h3>
<p></p>

	<table class="table">
      <thead>
        <tr>
          <th scope="col">User management</th>
          <th scope="col">Catalog management</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><a href = "<c:url value = "do?command=ViewUsers"/>">VIEW USERS</a></td>
          <td><a href = "<c:url value = "do?command=EditProducts"/>">EDIT PRODUCTS</a></td>
        </tr>
                <tr>
                  <td><a href = "<c:url value = "do?command=CreateUser"/>">CREATE USER</a></td>
                  <td><a href = "<c:url value = "do?command=createproduct"/>">NEW PRODUCT</a></td>
                </tr>
                        <tr>
                          <td><a href = "<c:url value = "do?command=EditUsers"/>">EDIT USERS</a></td>
                          <td><a href = "<c:url value = "do?command=CreateCategory"/>">NEW CATEGORY</a></td>
                        </tr>


      </tbody>
    </table>


</div>
</body>
</html>