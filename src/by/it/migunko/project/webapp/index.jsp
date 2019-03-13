<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <table class="table">
            <thead>
            <tr>
                <th scope="col">Описание</th>
                <th scope="col">Тип тура</th>
                <th scope="col">Место назначения</th>
                <th scope="col">Отель</th>
                <th scope="col">Количество ночей</th>
                <th scope="col">Стоимость</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="tours" items="${tours}">
                <tr>
                    <td>${tours.description}</td>
                    <td>${tours.typeOfTravel}</td>
                    <td>${tours.destination}</td>
                    <td>${tours.hotel}</td>
                    <td>${tours.countOfNights}</td>
                    <td>${tours.price}</td>
                </tr>
            </c:forEach>
            </tbody>
    </table>
</div>
</body>
</html>
