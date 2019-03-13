<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" >
               <fieldset>

               <!-- Form Name -->
               <legend>Form Name</legend>

               <!-- Text input-->
               <div class="form-group">
                 <label class="col-md-4 control-label" for="login">login</label>
                 <div class="col-md-4">
                 <input id="login" name="login" type="text" placeholder="enter login" class="form-control input-md" required="">

                 </div>
               </div>

               <!-- Password input-->
               <div class="form-group">
                 <label class="col-md-4 control-label" for="password">password</label>
                 <div class="col-md-4">
                   <input id="password" name="password" type="password" placeholder="enter password" class="form-control input-md" required="">

                 </div>
               </div>

               <!-- Button -->
               <div class="form-group">
                 <label class="col-md-4 control-label" for="Submit">Submit</label>
                 <div class="col-md-4">
                   <button id="Sumit" name="Submit" class="btn btn-primary">Submit</button>
                 </div>
               </div>

               </fieldset>
               </form>




</div>
</body>
</html>

