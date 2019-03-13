<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="do?command=index">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="do?command=ResetDB">ResetDB</a>
            <c:choose>
                <c:when test="${user==null}">
            <a class="nav-item nav-link" href="do?command=Login">Login</a>
            <a class="nav-item nav-link" href="do?command=Signup">Signup</a>
            <a class="nav-item nav-link" href="do?command=Catalog">Catalog</a>
                </c:when>
                <c:when test="${user.id>1}">
            <a class="nav-item nav-link" href="do?command=Catalog">Catalog</a>
            <a class="nav-item nav-link" href="do?command=Profile">Profile</a>
            <a class="nav-item nav-link" href="do?command=Logout">Logout</a>
            <a class="nav-item nav-link" href="do?command=Cart">Cart</a>
                </c:when>
                <c:when test="${user.id==1}">
            <a class="nav-item nav-link" href="do?command=Catalog">Catalog</a>
            <a class="nav-item nav-link" href="do?command=Profile">Profile</a>
            <a class="nav-item nav-link" href="do?command=Logout">Logout</a>
            <a class="nav-item nav-link" href="do?command=Cart">Cart</a>
            <a class="nav-item nav-link" href="do?command=Admin">Admin</a>
                </c:when>

            </c:choose>
        </div>
    </div>
</nav>
