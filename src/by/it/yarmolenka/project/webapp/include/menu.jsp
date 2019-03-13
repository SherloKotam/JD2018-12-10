<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
	<a class="navbar-brand" href="do?command=Index">Races</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="do?command=Reset">Reset Data<span class="sr-only">(current)</span></a>
			</li>
		</ul>
	</div>
	<div class="collapse navbar-collapse justify-content-end" id="navbarNav">
		<ul class="navbar-nav">
			<c:if test="${user.fk_roles==2}">
				<li class="nav-item">
					<a class="nav-link" href="do?command=Profile">Profile</a>
				</li>
			</c:if>
			<c:if test="${user.fk_roles==1}">
				<li class="nav-item">
					<a class="nav-link" href="do?command=AdminPanelProfile">Admin Panel</a>
				</li>
			</c:if>
			<c:if test="${user==null}">
				<li class="nav-item">
					<a class="nav-link" href="do?command=Login">Login</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="do?command=Register">Register</a>
				</li>
			</c:if>
			<c:if test="${user!=null}">
				<li class="nav-item">
					<a class="nav-link" href="do?command=Logout">Logout</a>
				</li>
			</c:if>
		</ul>
	</div>
</nav>