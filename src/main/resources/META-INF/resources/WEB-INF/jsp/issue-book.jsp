<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/main.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/style.jspf"%>

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
		<form:input type="hidden" path="bookName" required="required" />
		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>