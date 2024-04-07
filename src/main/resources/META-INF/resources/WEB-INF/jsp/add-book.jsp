<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="style/style.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="common/header.jspf"%>

<div class="container">


	<form:form method="post" modelAttribute="library">
		<h2>Enter Book Details:</h2>
		<form:input type="hidden" path="bookId" required="required" />
			Book Name: <form:input type="text" path="bookName"
			required="required" />
			Author Name: <form:input type="text" path="authorName"
			required="required" />
			Price: <form:input type="text" path="price" required="required" />
		<form:errors path="price" required="required" />
		<br>
		<input type="submit" class="btn btn-success" />
		<form:input type="hidden" path="done" required="required" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
