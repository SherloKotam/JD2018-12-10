<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <p><h3>${admin.login}</h3></p>

    <form class="form-horizontal" action="do?command=Admin" method="post">
    <div class="form-group">
        <label class="col-md-4 control-label" for="logout"></label>
        <div class="col-md-4">
            <button id="logout" name="logout" class="btn btn-primary">Log out</button>
         </div>
    </div>
    </form>

    <div class="row">
        <div class=col-md-1>Login</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-2>Address</div>
        <div class=col-md-1>Name</div>
        <div class=col-md-2>Surname</div>
        <div class=col-md-2>NumberPhone</div>
        <div class=col-md-2>Role</div>
    </div>
    <c:forEach items="${users}" var="user">
        <form class="form-horizontal-${user.id}" action="do?command=Admin" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                 required="" value="${user.id}">
                <div class="col-md-1">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                     required="" value="${user.login}">
                </div>
                <div class="col-md-2">
                    <input id="email" name="email" type="text" placeholder="youremail@gmail.com" class="form-control input-md"
                     required="" value="${user.email}">
                </div>
                <div class="col-md-2">
                    <input id="address" name="address" type="text" placeholder="Независимости, 5-15" class="form-control input-md"
                     value="${user.address}">
                    </div>
                <div class="col-md-1">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
                     value="${user.name}">
                </div>
                <div class="col-md-2">
                    <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md"
                     value="${user.surname}">
                </div>
                <div class="col-md-2">
                    <input id="numberphone" name="numberphone" type="text" placeholder="336483064" class="form-control input-md"
                     value="${user.numberphone}">
                </div>
                <div class="col-md-2">
                    <select id="roles_id" name="roles_id" class="form-control">
                        <c:forEach items="${roles}" var="role">
                        <option value="${role.id}" ${user.roles_id==role.id?"selected":""}>${role.role}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-4">
                    <button id="update" name="update" class="btn btn-success">Update</button>
                    <button id="delete" name="delete" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </form>
    </c:forEach>

    <hr>
        <mytag:paginator count="${usersCount}" step="5" urlprefix="do?command=Profile&start="/>
    <hr>


</div>
</body>
</html>
