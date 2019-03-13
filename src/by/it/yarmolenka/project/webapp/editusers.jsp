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
                    <a class="nav-link" href="do?command=AdminPanelProfile">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="do?command=EditUsers">Edit users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=EditRaces">Edit races</a>
                </li>
            </ul>
			<hr>
			<div class="row">
			    <div class="col-md-2 text-center">Login</div>
			    <div class="col-md-2 text-center">Email</div>
			    <div class="col-md-2 text-center">Password</div>
			    <div class="row col-md-3">
			    <div class="col-md-6 text-center">Cashier</div>
			    <div class="col-md-6 text-center">Role</div>
			    </div>
			</div>
			<br>
			<c:forEach items="${users}" var="user">
			    <form class="form-horizontal" action="do?command=EditUsers" method="post">
                    <div class="row">

                        <div>
                            <input id="id" name="id" value="${user.id}" type="hidden" class="form-control input-md">
                        </div>

                        <div class="col-md-2">
                            <input id="login" name="login" type="text" value="${user.login}" class="form-control input-md" pattern="\w+">
                        </div>

                        <div class="col-md-2">
                            <input id="email" name="email" type="text" value="${user.email}" class="form-control input-md" pattern="\w+@[a-z]{2,}\.[a-z]{2,}">
                        </div>

                        <div class="col-md-2">
                            <input id="password" name="password" type="password" value="${user.password}" class="form-control input-md" pattern="\w+">
                        </div>

                        <div class="row col-md-3">
                        <div class="col-md-6">
                            <input id="cashier" name="cashier" type="text" value="${user.cashier}" class="form-control input-md" pattern="[0-9\.]+">
                        </div>

                        <div class="col-md-6">
                            <select id="role" name="role" class="form-control">
                                <c:forEach items="${roles}" var="role">
                                    <option value="${role.id}" ${user.fk_roles==role.id?"selected":""}>${role.role}</option>
                                </c:forEach>
                            </select>
                        </div>
                        </div>

                        <div class="col-md-3">
                            <a href="do?command=EditBets&userId=${user.id}" class="btn btn-warning" role="button">Bets</a>
                            <button id="edit" name="edit" class="btn btn-success">Edit</button>
                            <button id="delete" name="delete" class="btn btn-danger">Delete</button>
                        </div>
                    </div>
                </form>
			</c:forEach>
			<form class="form-horizontal" action="do?command=EditUsers" method="post">
                <div class="row">

                    <div class="col-md-2">
                        <input id="login" name="login" type="text" class="form-control input-md" required="" pattern="\w+">
                        <font color="red">${loginExists}</font>
                    </div>

                    <div class="col-md-2">
                        <input id="email" name="email" type="text" class="form-control input-md" required="" pattern="\w+@[a-z]{2,}\.[a-z]{2,}">
                    </div>

                    <div class="col-md-2">
                        <input id="password" name="password" type="password" class="form-control input-md" required="" pattern="\w+">
                    </div>

                    <div class="row col-md-3">
                    <div class="col-md-6">
                        <input id="cashier" name="cashier" type="text" class="form-control input-md" required="" pattern="[0-9\.]+">
                    </div>

                    <div class="col-md-6">
                        <select id="role" name="role" class="form-control">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" ${role.id==2?"selected":""}>${role.role}</option>
                            </c:forEach>
                        </select>
                    </div>
                    </div>

                    <div class="col-md-2">
                        <button id="create" name="create" class="btn btn-success">Create User</button>
                    </div>
                </div>
            </form>
		</div>
	</body>
</html>