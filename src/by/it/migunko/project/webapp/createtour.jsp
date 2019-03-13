<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=CreateTour" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend>Создание Тура</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="description">Описание</label>
      <div class="col-md-4">
      <input id="description" name="description" type="text" placeholder="" class="form-control input-md" required=""
      value="testDescription">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="typeOfTravel">Тип тура</label>
      <div class="col-md-4">
      <input id="typeOfTravel" name="typeOfTravel" type="text" placeholder="" class="form-control input-md" required=""
      value="testTypeOfTravel">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="destination">Место назначения</label>
      <div class="col-md-4">
      <input id="destination" name="destination" type="text" placeholder="" class="form-control input-md" required=""
      value="testDestination">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="hotel">Отель</label>
      <div class="col-md-4">
      <input id="hotel" name="hotel" type="text" placeholder="" class="form-control input-md" required=""
      value="testHotel">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="countOfNights">Количество ночей</label>
      <div class="col-md-4">
      <input id="countOfNights" name="countOfNights" type="text" placeholder="" class="form-control input-md" required=""
      value="11">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="price">Стоимость</label>
      <div class="col-md-4">
      <input id="price" name="price" type="text" placeholder="" class="form-control input-md" required=""
      value="555">

      </div>
    </div>
    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="submit"></label>
      <div class="col-md-4">
      <button id="submit" name="submit" class="btn btn-primary">Создать тур</button>
      </div>
    </div>
    </fieldset>
    </form>
</div>
</body>
</html>
