<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<form class="form-horizontal" action="do?command=Profile" method="post">
<fieldset>
    <h3>Hello, ${user.login}</h3>
    <br>
    <div class="form-group">
    <label class="col-md-3 control-label" for="email">Email</label>
        <div class="col-md-3">
           <input id="email" name="email" type="text" placeholder="youremail@gmail.com" class="form-control input-md"
           required="" value="${user.email}">
        </div>
    </div>
    <div class="form-group">
    <label class="col-md-3 control-label" for="address">Address</label>
        <div class="col-md-3">
           <input id="address" name="address" type="text" placeholder="Независимости, 5-15" class="form-control input-md"
           required="" value="${user.address}">
        </div>
    </div>
    <div class="form-group">
    <label class="col-md-3 control-label" for="name">Name</label>
        <div class="col-md-3">
           <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
           required="" value="${user.name}">
        </div>
    </div>
    <div class="form-group">
    <label class="col-md-3 control-label" for="surname">Surname</label>
        <div class="col-md-3">
           <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md"
           required="" value="${user.surname}">
        </div>
    </div>
    <div class="form-group">
    <label class="col-md-3 control-label" for="numberphone">NumberPhone</label>
        <div class="col-md-3">
           <input id="numberphone" name="numberphone" type="text" placeholder="336483064" class="form-control input-md"
           required="" value="${user.numberphone}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-0.5">
           <button id="save" name="save" class="btn btn-success">Save</button>
        </div>
    </div>

     <p></p>
        <p><h5>История заказов:</h5></p>

         <div class="row">
            <div class="col-md-4"><h6>Dish</h6></div>
            <div class="col-md-4"><h6>Count</h6></div>
            <div class="col-md-4"><h6>Check</h6></div>
         </div>

         <c:forEach items="${orders}" var="order">
            <div class="row">
                <div class="col-md-4">
                    <c:forEach items="${menu}" var="menu">
                        <c:if test="${menu.id==order.menu_id}">
                            <input id="dish" name="dish" type="text" placeholder="" class="form-control input-md"
                            required="" value="${menu.name}">
                        </c:if>
                    </c:forEach>
                </div>
                <div class="col-md-4">
                    <input id="count" name="count" type="text" placeholder="" class="form-control input-md"
                     required="" value="${order.count}">
                </div>
                <div class="col-md-4">
                     <input id="check" name="check" type="text" placeholder="" class="form-control input-md"
                      required="" value="${order.check}">
                </div>
            </div>
         </c:forEach>

         <hr>
             <mytag:paginator count="${ordersCount}" step="5" urlprefix="do?command=Profile&start="/>
         <hr>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-primary">Log out</button>
                </div>
            </div>

</fieldset>
</form>
</div>
</body>
</html>
