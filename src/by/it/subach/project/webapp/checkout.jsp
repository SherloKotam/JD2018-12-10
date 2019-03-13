<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

<c:choose>
    <c:when test="${message!=null}">
        <p>${message}</p>
    </c:when>

<c:otherwise>

<form class="form-horizontal" action="do?command=Checkout" method="post">
<fieldset>
    <!-- Form Name -->
    <legend>Checkout</legend>
    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="name">Name</label>
      <div class="col-md-4">
      <input id="name" name="name" type="text" placeholder="" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="tel">Telephone</label>
      <div class="col-md-4">
      <input id="tel" name="tel" type="text" placeholder="" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="cardnumber">Card Number</label>
      <div class="col-md-4">
      <input id="cardnumber" name="cardnumber" type="text" placeholder="" class="form-control input-md">

      </div>
    </div>

    <!-- Button (Double) -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="button1id"></label>
      <div class="col-md-8">
        <button id="payment" name="payment" class="btn btn-success">Payment</button>
        <button id="cancel" name="cancel" class="btn btn-danger">Cancel</button>
      </div>
    </div>
</fieldset>
</form>

</c:otherwise>
</c:choose>

</div>
</body>
</html>