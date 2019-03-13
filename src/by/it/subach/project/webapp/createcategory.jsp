<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=CreateCategory" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend>New Category</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="name">Category name</label>
      <div class="col-md-4">
      <input id="name" name="name" type="text" placeholder="" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="description">Description</label>
      <div class="col-md-4">
      <input id="description" name="description" type="text" placeholder="" class="form-control input-md">

      </div>
    </div>

    <!-- Button (Double) -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="okButton"></label>
      <div class="col-md-8">
        <button id="ok" name="ok" class="btn btn-success">Ok</button>
        <button id="cancel" name="cancel" class="btn btn-danger">Cancel</button>
      </div>
    </div>

    </fieldset>
    </form>
</div>
</body>
</html>