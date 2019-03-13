
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
     <h2>Все заявки</h2>

        <div class="row">
            <div class="col-md-3">Описание заявки</div>
            <div class="col-md-2">Дата создания</div>
            <div class="col-md-2">Планируемая дата завершения</div>
            <div class="col-md-1">Автор заявки</div>
            <div class="col-md-1">Статус заявки</div>
            <div class="col-md-3">адрес</div>
        </div>

        <c:forEach items="${requests}" var="request">
            <br>
            <div class="row">
                <div class="col-md-3">${request.type}</div>
                <div class="col-md-2">${request.date_create}</div>
                <div class="col-md-2">${request.date_complete}</div>
                <div class="col-md-1">${request.user_id}</div>
                <div class="col-md-1">${request.status_id}</div>
                <div class="col-md-3">${request.address_id}</div>
            </div>
        </c:forEach>
</div>
</body>
</html>
