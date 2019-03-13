<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>

<body>
    <div class="container">
        <%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=CreateUser" method="post">
<fieldset>

<!-- Form Name -->
<legend>Create User</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="role">Role</label>
  <div class="col-md-4">
    <select id="role" name="role" class="form-control">
      <option value="1">admin</option>
      <option value="2">user</option>
      <option value="3">guest</option>
    </select>
  </div>
</div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createuser"></label>
                <div class="col-md-4">
                    <button id="createuser" name="createuser" class="btn btn-primary">Create</button>
                </div>
            </div>

</fieldset>
</form>
    </div>
</body>

</html>