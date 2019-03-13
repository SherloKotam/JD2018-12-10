<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<h4>Logged in as <font color="green">${user.login}</font>. Your credit is <font color="green">${user.cashier}</font></h4>
			<hr>
			<c:choose>
                <c:when test="${confirmDelete!=null}">
                    <form class="form-horizontal" action="do?command=Profile" method="post">
                        <fieldset>
                            <div class="form-group">
                            <label class="col-md-4 control-label">Are you sure?</label>
                                <div class="col-md-8">
                                    <button id="deleteConfirmed" name="deleteConfirmed" class="btn btn-danger">Delete Profile</button>
                                    <button id="deleteCanceled" name="deleteCanceled" class="btn btn-success">Cancel</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </c:when>
                <c:otherwise>
                    <form class="form-horizontal" action="do?command=Profile" method="post">
                        <fieldset>
                            <legend>Edit profile data</legend>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="login">Login</label>
                                <div class="col-md-4">
                                    <input id="login" name="login" type="text" value="${user.login}" class="form-control input-md" pattern="\w+">
							        <font color="red">${userExists}</font>
							        <span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="email">Email</label>
                                <div class="col-md-4">
                                    <input id="email" name="email" type="text" value="${user.email}" class="form-control input-md" pattern="\w+@[a-z]{2,}\.[a-z]{2,}">
                                </div>
                            </div>
                            <div class="form-group">
                                <button id="edit" name="edit" class="btn btn-success">Edit profile</button>
                                <button id="delete" name="delete" class="btn btn-danger">Delete profile</button>
                            </div>
                        </fieldset>
                    </form>
                    <a href="do?command=ChangePass" class="btn btn-success" role="button">Change password</a>
                </c:otherwise>
            </c:choose>
			<hr>
			<h4>My Bets:</h4>
			<table class="table table-striped">
				<thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Date</th>
                        <th scope="col">Race description</th>
                        <th scope="col">Event description</th>
                        <th scope="col">Bet Amount</th>
                        <th scope="col">Odds</th>
                        <th scope="col">Payout</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userBets}" var="bet">
					    <tr>
						<th scope="row">${bet.id}</th>
						<td>
							<c:forEach items="${events}" var="event">
								<c:if test="${bet.fk_events == event.id}">
									<c:forEach items="${races}" var="race">
										<c:if test="${event.fk_races == race.id}">
											${race.date}
										</c:if>
									</c:forEach>
								</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${events}" var="event">
								<c:if test="${bet.fk_events == event.id}">
									<c:forEach items="${races}" var="race">
										<c:if test="${event.fk_races == race.id}">
											${race.description}
										</c:if>
									</c:forEach>
								</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${events}" var="event">
								<c:if test="${bet.fk_events == event.id}">
									${event.description}
								</c:if>
							</c:forEach>
						</td>
						<td>${bet.amount}</td>
						<td>
							<c:forEach items="${events}" var="event">
								<c:if test="${bet.fk_events == event.id}">
									${event.odds}
								</c:if>
							</c:forEach>
						</td>
						<td>${bet.payout}</td>
						</tr>
					</c:forEach>
				</tbody>
            </table>
		</div>
	</body>
</html>
