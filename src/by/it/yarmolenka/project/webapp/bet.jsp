<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=Bet&EventId=${event.id}" method="post">
    <fieldset>
        <legend>Bet Confirmation</legend>
        <div class="col-md-6">
            <table class="table">
                <tbody>
                    <tr>
                        <th>Available amount</th>
                        <td>${user.cashier}</td>
                    </tr>
                    <tr>
                        <th>Race</th>
                        <td>${raceDescription}</td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>${event.description}</td>
                    </tr>
                    <tr>
                        <th>Odds</th>
                        <td>${event.odds}</td>
                    </tr>
                    <tr>
                        <th>Bet amount</th>
                        <td>
                            <input id="fk_users" name="fk_users" type="hidden" value="${user.id}" class="form-control input-md">
                            <input id="fk_events" name="fk_events" type="hidden" value="${event.id}" class="form-control input-md">
                            <input id="amount" name="amount" type="text" class="form-control input-md" required="" pattern="[0-9.]+">
                            <font color="red">${noMoney}</font>
							<span class="help-block" style="color:green">Use numbers and point</span>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button id="confirm" name="confirm" class="btn btn-success">Confirm</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
</form>
</div>
</body>
</html>


