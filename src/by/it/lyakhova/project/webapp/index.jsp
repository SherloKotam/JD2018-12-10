<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/menu.jsp" %>
<div class="container">

   <!-- <p>INDEX: ${tours}</p>
    <p>TOURS TYPES: ${tour_type}</p>
    <p>User: ${user}</p>-->

    <div class="row" align="center">

        <div class="col-md-1">Фото</div>
        <div class="col-md-2">Name</div>
        <div class="col-md-1">Type</div>
        <div class="col-md-2">Country</div>
        <div class="col-md-1">Town</div>
        <div class="col-md-1">Transport</div>
        <div class="col-md-1">Housing</div>
        <div class="col-md-1">Price</div>
        <div class="col-md-1">Date</div>
        <div class="col-md-1">Duration</div>

    </div>

    <hr>
    <c:forEach items="${tour}" var="tour">
          <div class="row" align="center">
              <div class="col-md-1">
                 <a href="images/tour${tour.id}" target="_blank">
                      <img src="images/tour${tour.id}" height="40px">
                 </a>
              </div>
              <div class="col-md-2">${tour.name}</div>
              <div class="col-md-1">${tour.tour_type}</div>
              <div class="col-md-2">${tour.country}</div>
              <div class="col-md-1">${tour.town}</div>
              <div class="col-md-1">${tour.transport}</div>
              <div class="col-md-1">${tour.housing}</div>
              <div class="col-md-1">${tour.price}</div>
              <div class="col-md-1">${tour.date}</div>
              <div class="col-md-1">${tour.duration}</div>

          </div>
    </c:forEach>

    <hr> <mytag:paginator count="${tourCount}" step="12" urlprefix="do?command=Index&start="/>

</div>
</body>
</html>
