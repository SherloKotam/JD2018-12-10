<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">

<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=CreateAd" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Create Ad</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">description</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="description" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">address</label>
  <div class="col-md-4">
  <input id="address" name="address" type="text" placeholder="address" class="form-control input-md" required="">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="floor">Floor</label>
  <div class="col-md-4">
    <select id="floor" name="floor" class="form-control">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
      <option value="6">6</option>
      <option value="7">7</option>
      <option value="8">8</option>
      <option value="9">9</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="more">more</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="floors">Floors</label>
  <div class="col-md-4">
    <select id="floors" name="floors" class="form-control">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
      <option value="6">6</option>
      <option value="7">7</option>
      <option value="8">8</option>
      <option value="9">9</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="more">more</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="area">Area</label>
  <div class="col-md-4">
  <input id="area" name="area" type="text" placeholder="area" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Price</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="price input" class="form-control input-md" required="">

  </div>
</div>

<!-- Select Multiple -->
<div class="form-group">
  <label class="col-md-4 control-label" for="rooms">Rooms</label>
  <div class="col-md-4">
    <select id="rooms" name="rooms" class="form-control" multiple="multiple">
      <option value="1">1-bedroom</option>
      <option value="2">2-bedroom</option>
      <option value="3">3-bedroom</option>
      <option value="4">4-bedroom</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="create"></label>
  <div class="col-md-4">
    <button id="create" name="create" class="btn btn-primary">CREATE AD</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>

