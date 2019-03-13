<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Date</th>
						<th scope="col">Race Track</th>
						<th scope="col">Description</th>
						<th scope="col">Events</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${races}" var="race">
						<tr >
							<td>${race.date}</td>
							<td>${race.race_track}</td>
							<td>${race.description}</td>
							<td>
							    <a href="do?command=GetEvents&raceEv=${race.id}" class="btn btn-success btn-sm" role="button">See events</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
            </table>
		</div>
	</body>
</html>
