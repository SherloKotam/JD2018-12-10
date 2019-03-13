<html>
    <%@ include file="include/head.jsp" %>
    <body>
        <div class="container">
            <%@ include file="include/menu.jsp" %>
			<table class="table table-striped">
				<thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Date</th>
                        <th scope="col">Race</th>
                        <th scope="col">Description</th>
                        <th scope="col">Odds</th>
                        <th scope="col">Bet</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${events}" var="event">
						<tr>
							<th scope="row">${event.id}</th>
							<td>
								<c:forEach items="${races}" var="race">
									<c:if test="${event.fk_races == race.id}">
										${race.date}
									</c:if>
								</c:forEach>
							</td>
							<td>
								<c:forEach items="${races}" var="race">
									<c:if test="${event.fk_races == race.id}">
										${race.description}
									</c:if>
								</c:forEach>
							</td>
							<td>${event.description}</td>
							<td>${event.odds}</td>
							<td>
								<a href="do?command=Bet&EventId=${event.id}" class="btn btn-success" role="button">Bet</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
            </table>
		</div>
    </body>
</html>
