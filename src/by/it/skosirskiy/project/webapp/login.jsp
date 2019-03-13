
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    User: ${user}
    <br>

    <form class="form-horizontal" action="do?command=Login" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>User</legend>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="admin1" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="admin1" type="password" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="loginButton"></label>
                <div class="col-md-4">
                    <button id="loginButton" name="loginButton" class="btn btn-primary">Войти</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>

