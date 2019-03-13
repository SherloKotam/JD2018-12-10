<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <!--<p>User: ${user}</p>-->

    <form class="form-horizontal" method="post" action="do?command=CreateTour">
        <fieldset>
            <legend>Tour</legend>

            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Tour name</label>
                <div class="col-md-4">
                    <input id="name" value="TestValue name" name="name" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="tour_type_id">Tour type</label>
                <div class="col-md-4">
                    <select id="tour_type_id" name="tour_type_id" class="form-control">
                    <option disabled>chose the type of tour</option>
                        <c:forEach items="${tour_type}" var="type">
                            <option value="${type.id}" ${tours.tour_type_id==type.id?"selected":""}>
                                ${type.type}
                            </option>
                        </c:forEach>
                    </select>
                    <!--<input id="tour_type_id" name="tour_type_id"  value="1" type="text" placeholder="" class="form-control input-md" required="">-->
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="place_id">Place</label>
                <div class="col-md-4">
                    <select id="place_id" name="place_id" class="form-control">
                    <option disabled>chose the place</option>
                        <c:forEach items="${place}" var="place">
                            <option value="${place.id}" ${tours.place_id==place.id?"selected":""}>
                                ${place.country} ${place.town}
                            </option>
                        </c:forEach>
                    </select>
                   <!-- <input id="place_id" name="place_id"  value="3" type="text" placeholder=""
                   class="form-control input-md" required="">-->
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="transport_id">Transport</label>
                <div class="col-md-4">
                    <select id="transport_id" name="transport_id" class="form-control">
                    <option disabled>chose the transport</option>
                        <c:forEach items="${transport}" var="transport">
                            <option value="${transport.id}" ${tours.transport_id==transport.id?"selected":""}>
                                ${transport.type}
                            </option>
                        </c:forEach>
                    </select>
                  <!--  <input id="transport_id" name="transport_id"  value="3" type="text" placeholder=""
                  class="form-control input-md" required="">-->
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="housing_id">Housing</label>
                <div class="col-md-4">
                    <select id="housing_id" name="housing_id" class="form-control">
                    <option disabled>chose the housing</option>
                        <c:forEach items="${housing}" var="house">
                            <option value="${house.id}" ${tours.housing_id==house.id?"selected":""}>
                                ${house.type}
                            </option>
                        </c:forEach>
                    </select>

                    <!--<input id="housing_id" name="housing_id"  value="1" type="text" placeholder=""
                    class="form-control input-md" required="">-->
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Price</label>
                <div class="col-md-4">
                    <input id="price" name="price"  value="55555" type="text" placeholder=""
                    class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="date">Date</label>
                <div class="col-md-4">
                    <input id="date" name="date"  value="10.05.2019" type="text" placeholder="Date format DD.MM.YYYY"
                    class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
             <div class="form-group">
                 <label class="col-md-4 control-label" for="duration">Duration</label>
                 <div class="col-md-4">
                     <input id="duration" name="duration"  value="10" type="text" placeholder=""
                     class="form-control input-md" required="">

                 </div>
             </div>

            <!-- Text input-->
            <div class="form-group">
                 <label class="col-md-4 control-label" for="hot">Hot</label>
                 <div class="col-md-4">
                      <input id="hot" name="hot"  value="0" type="text" placeholder="Only Yes or No"
                      class="form-control input-md" required="">

                 </div>
            </div>


            <!-- Text input-->
            <div class="form-group">
                 <label class="col-md-4 control-label" for="discount">Area</label>
                 <div class="col-md-4">
                     <input id="discount" name="discount"  value="0" type="text" placeholder=""
                     class="form-control input-md" required="">

                 </div>
            </div>

            <!-- File Button -->
             <div class="form-group">
                  <label class="col-md-4 control-label" for="fileimg">File Button</label>
                  <div class="col-md-4">
                      <input id="fileimg" name="fileimg" class="input-file" type="file">
                  </div>
             </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createtour"></label>
                <div class="col-md-4">
                    <button id="createtour" name="createTour" class="btn btn-success">Create Tour</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>


