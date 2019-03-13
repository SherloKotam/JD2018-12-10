<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=SignUp" method="post">
<fieldset>

<legend>Sign up</legend>

<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
  required="">

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder=""
    class="form-control input-md" required="">

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="youremail@gmail.com"
  class="form-control input-md" required="">

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address</label>
  <div class="col-md-4">
  <input id="address" name="address" type="text" placeholder="Независимости, 5-15" class="form-control input-md">

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="surname">Surname</label>
  <div class="col-md-4">
  <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="numberphone">Phone Number</label>
  <div class="col-md-4">
  <input id="numberphone" name="numberphone" type="text" placeholder="336483064" class="form-control input-md">

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button id="signup" name="signup" class="btn btn-primary">Sign up</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>




