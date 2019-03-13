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
                    <a class="nav-link active" href="do?command=EditUsers">Edit users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=EditRaces">Edit races</a>
                </li>
            </ul>
			<hr>
			<table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Gambler</th>
                        <th scope="col">Race</th>
                        <th scope="col">Description</th>
                        <th scope="col">Odds</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Payout</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${userBets}" var="bet">
                        <tr>
                            <td>
                                ${userLogin}
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
                            <td>
                                <c:forEach items="${events}" var="event">
                                    <c:if test="${bet.fk_events == event.id}">
                                        ${event.odds}
                                    </c:if>
                                </c:forEach></td>
                            <td>
                                ${bet.amount}
                            </td>
                            <td>
                                ${bet.payout}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
		</div>
	</body>
</html>