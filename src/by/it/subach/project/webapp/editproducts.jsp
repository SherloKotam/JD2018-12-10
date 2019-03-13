<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <div class="row">
        <div class=col-md-2>Название</div>
        <div class=col-md-2>Цена</div>
        <div class=col-md-2>Описание</div>
        <div class=col-md-2>Категория</div>
    </div>
    <c:forEach items="${products}" var="product">
        <form class="form-horizontal-${product.id}" action="do?command=EditProducts" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${product.id}">

                <div class="col-md-2">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
                           required="" value="${product.name}">

                </div>

                <div class="col-md-2">
                    <input id="price" name="price" type="price" placeholder="" class="form-control input-md"
                           required="" value="${product.price}">

                </div>

                <div class="col-md-2">
                    <input id="description" name="description" type="text" placeholder="" class="form-control input-md"
                           required="" value="${product.description}">
                </div>

                <div class="col-md-2">
                    <select id="categories_id" name="categories_id" class="form-control">
                        <c:forEach items="${categories}" var="category">
                        <option value="${category.id}" ${product.categories_id==category.id?"selected":""}>${category.name}</option>
                        </c:forEach>
                    </select>
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


