<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="style/style.jspf"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<form:form method="post" modelAttribute="library">
		<h2>Enter Book Details:</h2>
			Book Id: <form:input type="number" path="bookId" required="required"
			min="1" />
			Book Name: <form:input type="text" path="bookName"
			required="required" />
			Author Name: <form:input type="text" path="authorName"
			required="required" />
			<pre>${errorAuth}</pre>
			Total: <form:input type="number" path="totalBooks"
			required="required" />
			<pre>${errorTotal}</pre>
		<br>
		<input type="submit" class="btn btn-success" />
		<pre>${errorBook}</pre>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
