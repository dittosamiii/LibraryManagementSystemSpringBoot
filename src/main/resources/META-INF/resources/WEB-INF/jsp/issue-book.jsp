<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="style/style.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="common/header.jspf"%>

<div class="container">
	<form:form method="post" modelAttribute="issueBook">
		<h2>Enter Book to issue:</h2>
		<form:input type="hidden" path="bookId" required="required" />
			Student Id: <form:input type="text" path="studentId"
			required="required" />
			 Student Name: <form:input type="text" path="studentName"
			required="required" />
			Issue Date: <form:input type="date" path="issueDate"
			required="required" />
			Return Date: <form:input type="date" path="returnDate"
			required="required" />
		<pre>${errorMessage}</pre>
		<form:input type="hidden" path="bookName" required="required" />
		<br>
		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>