<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" method="post" action="do?command=Login">
        <fieldset>
        <!-- Form Name -->
        <legend>Вход</legend>
        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="login">Логин</label>
          <div class="col-md-4">
          <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required=""
          value="testLogin">
          <span class="help-block">Enter your login</span>
          </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="password">Пароль</label>
          <div class="col-md-4">
            <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required=""
            value="testPassword">
            <span class="help-block">Enter your password</span>
          </div>
        </div>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="submit"></label>
          <div class="col-md-4">
            <button id="submit" name="submit" class="btn btn-success">Войти</button>
          </div>
        </div>
        </fieldset>
        </form>
</div>
</body>
</html>

