<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=signup" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Registration</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="email">Email</label>
              <div class="col-md-4">
              <input id="email" name="email" type="text" placeholder="example@mail.com" class="form-control input-md">
              <span class="help-block">Enter your email</span>
              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="login">Login</label>
              <div class="col-md-4">
              <input id="login" name="login" type="text" placeholder="" class="form-control input-md">
              <span class="help-block">Enter your login</span>
              </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="passwordinput">Password</label>
              <div class="col-md-4">
                <input id="passwordinput" name="passwordinput" type="password" placeholder="" class="form-control input-md">
                <span class="help-block">Enter your password</span>
              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="signup"></label>
              <div class="col-md-4">
                <button id="signup" name="signup" class="btn btn-primary">Registration</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>