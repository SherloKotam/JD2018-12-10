<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

<form class="form-horizontal" action="do?command=Order" method="post">
<fieldset>

<legend>Menu</legend>

<div class="form-group">
    <label class="col-md-2 control-label" for="dish">Dish</label>
        <div class="col-md-2">
        <select id="dish" name="dish" class="form-control">
            <c:forEach items="${menu}" var="menu">
            <option value="${menu.name}">${menu.name}</option>
            </c:forEach>
        </select>
        </div>
</div>

<div class="form-group">
    <label class="col-md-2 control-label" for="count">Count</label>
        <div class="col-md-2">
        <input id="count" name="count" type="text" placeholder="" class="form-control input-md">
        </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="order"></label>
  <div class="col-md-4">
    <button id="order" name="order" class="btn btn-primary">Order</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>