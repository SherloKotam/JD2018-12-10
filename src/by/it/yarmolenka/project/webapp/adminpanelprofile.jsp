<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<h4>Logged in as <font color="green">${user.login}</font></h4>
			<hr>
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
			<c:choose>
                <c:when test="${confirmDelete!=null}">
                    <form class="form-horizontal" action="do?command=AdminPanelProfile" method="post">
                        <fieldset>
                            <div class="form-group">
                            <label class="col-md-4 control-label">Are you sure?</label>
                                <div class="col-md-8">
                                    <button id="deleteConfirmed" name="deleteConfirmed" class="btn btn-danger">Delete Profile</button>
                                    <button id="deleteCanceled" name="deleteCanceled" class="btn btn-success">Cancel</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </c:when>
                <c:otherwise>
                    <form class="form-horizontal" action="do?command=AdminPanelProfile" method="post">
                        <fieldset>
                            <legend>Edit profile data</legend>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="login">Login</label>
                                <div class="col-md-4">
                                    <input id="login" name="login" type="text" value="${user.login}" class="form-control input-md" pattern="\w+">
							        <font color="red">${userExists}</font>
							        <span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="email">Email</label>
                                <div class="col-md-4">
                                    <input id="email" name="email" type="text" value="${user.email}" class="form-control input-md" pattern="\w+@[a-z]{2,}\.[a-z]{2,}">
                                </div>
                            </div>
                            <div class="form-group">
                                <button id="edit" name="edit" class="btn btn-success">Edit profile</button>
                                <button id="delete" name="delete" class="btn btn-danger">Delete profile</button>
                            </div>
                        </fieldset>
                    </form>
                    <a href="do?command=ChangePass" class="btn btn-success" role="button">Change password</a>
                </c:otherwise>
            </c:choose>
		</div>
	</body>
</html>