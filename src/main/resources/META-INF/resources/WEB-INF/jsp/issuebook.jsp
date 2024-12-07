<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="style/style.jspf"%>

<div class="container">
	<form:form method="post" modelAttribute="issueBook">
		<h2>Enter Book to issue:</h2>
		<form:input type="hidden" path="bookId" required="required" />
			Student Id: <form:input type="number" path="studentId"
			required="required" />
		<pre>${error}</pre>
			 Student Name: <form:input type="text" path="studentName"
			required="required" />
		<pre>${errorStud}</pre>
			Issue Date: <form:input type="date" path="issueDate"
			required="required" />
		<pre>${errorMessage1}</pre>
			Return Date: <form:input type="date" path="returnDate"
			required="required" />
		<pre>${errorMessage}</pre>
		<form:input type="hidden" path="bookName" required="required" />
		<br>
		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>