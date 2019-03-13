<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <!--<p>User ${user}</p>
    <p>Туры пользователя: ${tours}</p>-->

    <div class="row" align="center">

        <div class="col-md-2">Фото</div>
        <div class="col-md-2">Name</div>
        <div class="col-md-2">Price</div>
        <div class="col-md-2">Date</div>
        <div class="col-md-2">Duration</div>

    </div>

    <hr>
        <c:forEach items="${tours}" var="tour">
              <div class="row" align="center">
                  <div class="col-md-2">
                     <a href="images/tour${tour.id}" target="_blank">
                          <img src="images/tour${tour.id}" height="40px">
                     </a>
                  </div>
                  <div class="col-md-2">${tour.name}</div>
                  <div class="col-md-2">${tour.price}</div>
                  <div class="col-md-2">${tour.date}</div>
                  <div class="col-md-2">${tour.duration}</div>

              </div>
        </c:forEach>

</div>
</body>
</html>