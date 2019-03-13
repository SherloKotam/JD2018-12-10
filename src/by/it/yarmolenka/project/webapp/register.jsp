<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<form class="form-horizontal" action="do?command=Register" method="post">
				<fieldset>
					<legend>Registration</legend>

					<div class="form-group">
						<label class="col-md-4 control-label" for="login">Login</label>
						<div class="col-md-4">
							<input id="login" name="login" type="text" value="gambler7" class="form-control input-md" required="" pattern="\w+">
							<font color="red">${loginExists}</font>
							<span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="email">Email</label>
						<div class="col-md-4">
							<input id="email" name="email" type="email" value="gambler7@mail.ru" class="form-control input-md" required="" pattern="\w+@[a-z]{2,}\.[a-z]{2,}">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="password">Password</label>
						<div class="col-md-4">
							<input id="password" name="password" type="password" value="gambler7pass" class="form-control input-md" required="" pattern="\w+">
							<span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="confirmPassword">Confirm password</label>
						<div class="col-md-4">
							<input id="confirmPassword" name="confirmPassword" type="password" value="gambler7pass" placeholder="confirm password" class="form-control input-md" required="" pattern="\w+">
							<font color="red">${passNotMatch}</font>
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