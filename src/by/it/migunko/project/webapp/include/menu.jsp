<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">Главная</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="do?command=ResetDB">Сброс базы данных</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=CreateTour">Создать Тур</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${user.roles_id==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="do?command=EditUsers">Редактор пользователей</a>
                    </li>
                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
    <div class="collapse navbar-collapse" id="navbarRight">
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${user!=null}">
                    <li class="nav-item">
                        <a class="nav-link" href="do?command=Profile">Профиль</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link" href="do?command=Login">Войти</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="do?command=SignUp">Регистрация</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
