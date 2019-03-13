<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
     <!-- <p>Пользователь: ${user}</p> -->

    <h2>Данные профиля</h2>
    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>


    <h2>Туры</h2>
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

    <form class="form-horizontal" method="post" action="do?command=Profile">
          <fieldset>
                <!-- Form Name -->
                <legend>Выход</legend>
                <!-- Button -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="submit"></label>
                  <div class="col-md-4">
                    <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
                  </div>
                </div>

          </fieldset>
    </form>
</div>
</body>
</html>
