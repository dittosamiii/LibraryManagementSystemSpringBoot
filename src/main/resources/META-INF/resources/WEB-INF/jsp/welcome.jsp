<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="style/mainStyle.jspf"%>

<div class="container">
	<h1>WELCOME TO THE LIBRARY</h1>
	<hr>
	<div>USER: ${name}</div>
	<hr>
	<div class="d-flex justify-content-around">
		<a href="library"
			class="btn btn-outline-light fs-4 w-25 text-center p-5"
			title="Books Can Be Seen Here"> Library </a> <a href="issue"
			class="btn btn-outline-light fs-4 w-25 text-center p-5"
			title="Issue Books can be seen here">Books Borrowed</a>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
