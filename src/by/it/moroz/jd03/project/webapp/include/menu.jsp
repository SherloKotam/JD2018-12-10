<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="do?command=Restaurant">Restaurant</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <c:choose>
                <c:when test="${user!=null}">
                    <c:if test="${user.roles_id==1}">
                        <a class="nav-item nav-link" href="do?command=Admin">Admin</a>
                    </c:if>
                    <c:if test="${user.roles_id!=1}">
                        <a class="nav-item nav-link" href="do?command=Profile">Profile</a>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <a class="nav-item nav-link" href="do?command=Login">Login</a>
                    <a class="nav-item nav-link" href="do?command=SignUp">Signup</a>
                </c:otherwise>
            </c:choose>
             <a class="nav-item nav-link" href="do?command=Order">Order</a>
            <a class="nav-item nav-link" href="do?command=Reset">ResetDB</a>
        </div>
    </div>
</nav>
