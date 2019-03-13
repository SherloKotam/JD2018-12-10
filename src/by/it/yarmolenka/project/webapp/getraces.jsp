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
						<c:if test="${user.fk_roles == 1}">
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${races}" var="race">
						<tr>
							<td>${race.date}</td>
							<td>${race.race_track}</td>
							<td>${race.description}</td>
							<c:if test="${user.fk_roles == 1}">
								<td>
									<form class="form-horizontal" action="do?command=EditRace&race_id=${race.id}" method="post">
										<fieldset>
											<div class="form-group">
												<div class="col-md-4">
													<button id="editrace" name="editrace" class="btn btn-warning">Edit</button>
												</div>
											</div>
										</fieldset>
									</form>
								</td>
								<td>
									<form class="form-horizontal" action="do?command=DeleteRace&race_id=${race.id}" method="post">
										<fieldset>
											<div class="form-group">
												<div class="col-md-4">
													<button id="deleterace" name="deleterace" class="btn btn-danger">Delete</button>
												</div>
											</div>
										</fieldset>
									</form>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
            </table>
		</div>
	</body>
</html>