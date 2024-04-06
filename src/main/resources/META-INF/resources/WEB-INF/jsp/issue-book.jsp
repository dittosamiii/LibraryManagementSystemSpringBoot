<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/main.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/style.jspf"%>

<div class="container">
	<form:form method="post" modelAttribute="issueBook">
		<h2>Enter Book to issue:</h2>
			Book Id: <form:input type="text" path="bookId" required="required" />
			Student Id: <form:input type="text" path="studentId"
			required="required" />
			 Student Name: <form:input type="text" path="studentName"
			required="required" />
				 Book Name: <form:input type="text" path="bookName"
			required="required" />
		<input type="submit" class="btn btn-success" />
		<form:input type="hidden" path="bookId" required="required" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>