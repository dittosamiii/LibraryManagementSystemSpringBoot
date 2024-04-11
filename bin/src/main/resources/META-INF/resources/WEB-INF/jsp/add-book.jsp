<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="style/style.jspf"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<form:form method="post" modelAttribute="library">
		<h2>Enter Book Details:</h2>
			Book Id: <form:input type="text" path="bookId" required="required" />
			Book Name: <form:input type="text" path="bookName"
			required="required" />
			Author Name: <form:input type="text" path="authorName"
			required="required" />
			Total: <form:input type="text" path="totalBooks" required="required" />
		<br>
		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
