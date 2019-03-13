<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<form class="form-horizontal" action="do?command=Restaurant" method="post">
<fieldset>
        <p><h3>MENU</h3></p>
        <div class="row">
                <div class="col-md-2"><h6>Dish</h6></div>
                <div class="col-md-2"><h6>Price</h6></div>
        </div>

            <c:forEach items="${menu}" var="menu">
                <div class="row">
                    <div class="col-md-2">
                        <input id="dish" name="dish" type="text" placeholder="" class="form-control input-md"
                        required="" value="${menu.name}">
                    </div>
                    <div class="col-md-2">
                        <input id="price" name="price" type="text" placeholder="" class="form-control input-md"
                        required="" value="${menu.price}">
                    </div>
                    <div class="col-md-2">
                        <button id="order" name="order" class="btn btn-success">Order</button>
                    </div>
                </div>
                <p></p>
            </c:forEach>
</fieldset>
</form>
</div>
</body>
</html>