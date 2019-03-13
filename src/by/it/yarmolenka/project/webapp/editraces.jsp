<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<h4>Logged in as <font color="green">${user.login}</font></h4>
			<hr>
			<ul class="nav nav-pills">
                <li class="nav-item">
                    <a class="nav-link" href="do?command=AdminPanelProfile">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=EditUsers">Edit users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="do?command=EditRaces">Edit races</a>
                </li>
            </ul>
			<hr>
			<div class="row">
                <div class="col-md-3 text-center">Date</div>
                <div class="col-md-3 text-center">Race track</div>
                <div class="col-md-3 text-center">Description</div>
            </div>
            <br>
            <c:forEach items="${races}" var="race">
                <form class="form-horizontal" action="do?command=EditRaces" method="post">
                      <div class="row">

                          <div>
                              <input id="id" name="id" value="${race.id}" type="hidden" class="form-control input-md" required="">
                          </div>

                          <div class="col-md-3">
                              <input id="date" name="date" type="datetime-local" value="${dates[race.id-1]}" class="form-control input-md" required="">
                          </div>

                          <div class="col-md-3">
                              <input id="race_track" name="race_track" type="text" value="${race.race_track}" class="form-control input-md" required="" pattern="[0-9А_Яа-яЁёA-Za-z\., -]+">
                          </div>

                          <div class="col-md-3">
                              <input id="description" name="description" type="text" value="${race.description}" class="form-control input-md" pattern="[0-9А_Яа-яЁёA-Za-z\., -]+">
					          <c:if test="${delId==race.id}">
					          <font color="red">${cannotDeleteRace}</font>
					          </c:if>
                          </div>

                          <div class="col-md-3">
                              <a href="do?command=EditEvents&raceEv=${race.id}" class="btn btn-warning" role="button">See events</a>
                              <button id="edit" name="edit" class="btn btn-success">Edit</button>
                              <button id="delete" name="delete" class="btn btn-danger">Delete</button>
                          </div>
                      </div>
                  </form>
            </c:forEach>
            <form class="form-horizontal" action="do?command=EditRaces" method="post">
                <div class="row">

                    <div class="col-md-3">
                        <input id="date" name="date" type="datetime-local" class="form-control input-md" required="">
                    </div>

                    <div class="col-md-3">
                        <input id="race_track" name="race_track" type="text" class="form-control input-md" required="" pattern="[0-9А_Яа-яЁёA-Za-z\., -]+">
                    </div>

                    <div class="col-md-3">
                        <input id="description" name="description" type="text" class="form-control input-md" required="" pattern="[0-9А_Яа-яЁёA-Za-z\., -]+">
                    </div>

                    <div class="col-md-3">
                        <button id="create" name="create" class="btn btn-success">Create Race</button>
                    </div>
                </div>
            </form>
		</div>
	</body>
</html>