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
			<h4><font color="red">${noDel}</font></h4>
			<table class="table table-striped">
			    <thead>
                    <tr>
                        <th scope="col">Date</th>
                        <th scope="col">Race</th>
                        <th scope="col">Description</th>
                        <th scope="col">Odds</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${events}" var="event">
                        <tr>
                            <form class="form-horizontal" action="do?command=EditEvents&raceEv=${raceEv}" method="post">
                                <td>
                                    <input id="id" name="id" value="${event.id}" type="hidden" class="form-control input-md">
                                    ${curRace.date}
                                </td>
                                <td>
                                    ${curRace.description}
                                </td>
                                <td>
                                    <input id="description" name="description" type="text" value="${event.description}" class="form-control input-md" required="" pattern="[0-9А_Яа-яЁёA-Za-z\., -]+">
                                </td>
                                <td>
                                    <input id="odds" name="odds" type="text" value="${event.odds}" class="form-control input-md" required="" pattern="[0-9\.]+">
                                </td>
                                <td>
                                    <button id="edit" name="edit" class="btn btn-success">Edit</button>
                                    <button id="delete" name="delete" class="btn btn-danger">Delete</button>
                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                    <tr>
                        <form class="form-horizontal" action="do?command=EditEvents&raceEv=${raceEv}" method="post">
                            <td>
                                <input id="id" name="id" type="hidden" class="form-control input-md">
                                ${curRace.date}
                            </td>
                            <td>
                                ${curRace.description}
                            </td>
                            <td>
                                <input id="description" name="description" type="text" class="form-control input-md" required="" pattern="[0-9А_Яа-яЁёA-Za-z\., -]+">
                            </td>
                            <td>
                                <input id="odds" name="odds" type="text" class="form-control input-md" required="" pattern="[0-9\.]+">
                            </td>
                            <td>
                                <button id="create" name="create" class="btn btn-success">Create event</button>
                            </td>
                        </form>
                    </tr>
                </tbody>
            </table>
		</div>
	</body>
</html>