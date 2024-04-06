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

	<form id="logoutForm" action="/logout" method="post">
		<h3>Confirm Logout</h3>
		<label>Are you sure you want to log out?</label> <input type="submit"
			value="Logout">
		<button class="btn btn-success" type="submit" name="cancel"
			value="true">Cancel</button>
	</form>

</body>