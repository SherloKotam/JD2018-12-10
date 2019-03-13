<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<p>${message}</p>
<form class="form-horizontal" action="do?command=ResetDB" method="post">
<fieldset>

<!-- Form Name -->
<legend>DB Reset</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="reset"></label>
  <div class="col-md-4">
    <button id="reset" name="reset" class="btn btn-primary">Reset</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>

