<html>
	<%@ include file="include/head.jsp" %>
	<body>
	<div class="container">
		<%@ include file="include/menu.jsp" %>
		<form class="form-horizontal" action="do?command=Login" method="post">
			<fieldset>
				<legend>Sign In</legend>

				<div class="form-group">
					<label class="col-md-4 control-label" for="login">Login</label>
					<div class="col-md-4">
						<input id="login" name="login" type="text" value="admin" class="form-control input-md" required="" pattern="\w+">
						<font color="red">${noUser}</font>
						<span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password</label>
					<div class="col-md-4">
						<input id="password" name="password" type="password" value="adminpass" class="form-control input-md" required="" pattern="\w+">
						<font color="red">${incorrectPass}</font>
						<span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-4">
						<button id="confirm" name="confirm" class="btn btn-primary">Confirm</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	</body>
</html>




