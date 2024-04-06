<%@ include file="common/header.jspf"%>
<%@ include file="common/main.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>WELCOME TO THE LIBRARY</h1>
	<hr>
	<div>USER: ${name}</div>
	<hr>
	<div class="d-flex justify-content-around">
		<a href="library" class="btn btn-outline-dark fs-4 w-25 text-center p-5" title="Books Can Be Seen Here" >Library</a>
	
		<a href="issue" class="btn btn-outline-light fs-4 w-25 text-center p-5" title="ISSUED Books can be seen here">Books Borrowed</a>

	</div>
	
</div>
<%@ include file="common/footer.jspf"%>
