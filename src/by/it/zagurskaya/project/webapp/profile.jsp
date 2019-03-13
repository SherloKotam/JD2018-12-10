<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <br>
     <H4>Пользователь ${user.login} с правами
     <c:forEach items="${roles}" var="role">
     <c:if test="${user.roleId==role.id}" >${role.name} </c:if>
     </c:forEach></H4>
     <br>
    <H4> ${messageDuties}</H4>
    --------------------------------------------------------------------------------------------------------------------------------------
    <div class="row">   <div class=col-md-2>|Пользователь</div>
                        <div class=col-md-3>|Время открытия</div>
                        <div class=col-md-2>|Номер смены</div>
                        <div class=col-md-2>|Признак закрытия</div>
                        <div class=col-md-1>|</div></div>
    --------------------------------------------------------------------------------------------------------------------------------------
            <div class="row">
                <div class="col-md-2"> <c:forEach items="${users}" var="users">
                <c:if test="${duties.userId==users.id}" >|${users.login} </c:if>
                </c:forEach></div>
                <div class="col-md-3">|${duties.timestamp}</div>
                <div class="col-md-2">|${duties.number}</div>
                <div class="col-md-2">|${duties.isClose}</div>
                <div class="col-md-1">|</div>
            </div>
    --------------------------------------------------------------------------------------------------------------------------------------
    <br>
    <form class="form-horizontal" action="do?command=Logout" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Logout</legend>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logoutButton"></label>
                <div class="col-md-4">
                    <button id="logoutButton" name="logoutButton" class="btn btn-primary">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>

