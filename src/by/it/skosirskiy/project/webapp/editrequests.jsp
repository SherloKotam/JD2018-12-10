
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="row">
        <div class=col-md-2>тип</div>
        <div class=col-md-2>Автор</div>
        <div class=col-md-2>Статус</div>
        <div class=col-md-2>Адрес</div>
    </div>
    <c:forEach items="${requests}" var="request">
        <form class="form-horizontal-${request.id}" action="do?command=EditRequests" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${request.id}">

                <div class="col-md-2">
                    <input id="type" name="type" type="text" placeholder="" class="form-control input-md"
                           required="" value="${request.type}">

                </div>

                <div class="col-md-2">
                    <input id="user_id" name="user_id" type="text" placeholder="" class="form-control input-md"
                           required="" value="${request.user_id}">
                </div>

                <div class="col-md-2">
                    <input id="status_id" name="status_id" type="text" placeholder="" class="form-control input-md"
                           required="" value="${request.status_id}">
                </div>
                <div class="col-md-2">
                    <input id="address_id" name="address_id" type="text" placeholder="" class="form-control input-md"
                           required="" value="${request.address_id}">
                </div>



                <!-- Button (Double) -->
                <div class="col-md-4">
                    <button id="update" name="update" class="btn btn-success">Обновить</button>
                    <button id="delete" name="delete" class="btn btn-danger">Удалить</button>
                </div>
            </div>
        </form>
    </c:forEach>


</div>
</body>
</html>


