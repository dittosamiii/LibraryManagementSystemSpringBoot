<!DOCTYPE html>
<html lang="en">
<head>
<title>My Library</title>

<%@ include file="common/style.jspf"%>
</head>
<body>
	<div class="background">
		<div class="shape"></div>
		<div class="shape"></div>
	</div>
	<form method="post">
		<h3>ADMIN PANEL</h3>

		<label for="username">Username</label> <input type="text"
			placeholder="Email or Phone" name="username"> <label
			for="password">Password</label> <input type="password"
			placeholder="Password" id="password" name="password">

		<button class="btn btn-success">Log In</button>
		<pre>${errorMessage}</pre>

	</form>
	<%@ include file="common/footer.jspf"%>