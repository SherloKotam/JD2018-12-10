<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Reset" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend></legend>

    <!-- Button -->
    <div class="form-group">
         <label class="col-md-4 control-label" for="reset">Are u shure?</label>
         <div class="col-md-4">
             <button id="reset" name="reset" class="btn btn-danger">Reset</button>
         </div>
    </div>

    </fieldset>
    </form>
</div>
</body>
</html>
