<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=CreateProduct" method="post">
<fieldset>

<!-- Form Name -->
<legend>New Product</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Product Name</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Price</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="description">Description</label>
  <div class="col-md-4">
  <input id="description" name="description" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="category">Category</label>
  <div class="col-md-4">
    <select id="category" name="category" class="form-control">
    	<c:forEach items="${categories}" var="category" varStatus="categoryCount">
            <option value="${category.id}">${category.name}</option>
    	</c:forEach>
    </select>
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