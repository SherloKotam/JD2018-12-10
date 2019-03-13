<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">Главная</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <div class="navbar-nav">
            <c:choose>
                <c:when test="${user!=null}">
                    <mytag:menu command="EditUsers" text="Администрирование пользователей"/>
                    <mytag:menu command="EditRequests" text="Администрирование заявок"/>
                    <mytag:menu command="CreateRequest" text="Создать объявление"/>
                    <mytag:menu command="ResetDB" text="Сброс базы данных"/>

                </c:when>
                <c:otherwise>
                <mytag:menu command="ResetDB" text="Сброс базы данных"/>
                </c:otherwise>
            </c:choose>
        </div>
        <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
            <c:choose>
                <c:when test="${user!=null}">
                    <mytag:menu command="Profile" text="Профиль"/>
                    <mytag:menu command="Logout" text="Выйти"/>
                </c:when>
                <c:otherwise>
                    <mytag:menu command="Login" text="Войти"/>
                    <mytag:menu command="SignUp" text="Регистрация"/>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>

