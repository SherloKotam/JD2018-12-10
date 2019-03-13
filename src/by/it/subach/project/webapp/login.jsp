<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>


<form class="form-horizontal" action="do?command=Login" method="post">
<fieldset>

<!-- Form Name -->
<legend>Login</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="Your login" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
  <input id="password" name="password" type="text" placeholder="Password" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="loginbutton"></label>
  <div class="col-md-4">
    <button id="loginbutton" name="loginbutton" class="btn btn-primary">Login</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>

