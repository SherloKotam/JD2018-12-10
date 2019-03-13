<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<h4>Logged in as <font color="green">${user.login}</font></h4>
			<hr>
			<c:if test="${user.fk_roles == 1}">
                <ul class="nav nav-pills">
                    <li class="nav-item">
                        <a class="nav-link active" href="do?command=AdminPanelProfile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="do?command=EditUsers">Edit users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="do?command=EditRaces">Edit races</a>
                    </li>
                </ul>
                <hr>
			</c:if>
			<form class="form-horizontal" action="do?command=ChangePass" method="post">
                <fieldset>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="oldPass">Old password</label>
                        <div class="col-md-4">
                            <input id="oldPass" name="oldPass" type="password" class="form-control input-md" required="" pattern="\w+">
						    <font color="red">${incorrectPass}</font>
							<span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="newPass">New password</label>
                        <div class="col-md-4">
                            <input id="newPass" name="newPass" type="password" class="form-control input-md" required="" pattern="\w+">
							<span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="confirmPass">Confirm password</label>
                        <div class="col-md-4">
                            <input id="confirmPass" name="confirmPass" type="password" class="form-control input-md" required="" pattern="\w+">
                            <font color="red">${passNotMatch}</font>
							<span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-4">
                            <button id="confirm" name="confirm" class="btn btn-success">Confirm</button>
                        </div>
                    </div>
                </fieldset>
            </form>
		</div>
	</body>
</html>