<%@ include file="common/header.jspf"%>
<%@ include file="style/mainStyle.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<div class="container">

	<h1>WELCOME ${name}</h1>
	<hr>
	<h2>Fine:</h2>
	<div class="table-responsive">
		<table class="table table-scrollable">
			<thead>
				<tr>
					<th>BOOK ID</th>
					<th>STUDENT ID</th>
					<th>ISSUE DATE</th>
					<th>DUE DATE</th>
					<th>RETURN DATE</th>
					<th>AMOUNT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fine}" var="lib">
					<tr>
						<td>${lib.bookId}</td>
						<td>${lib.studentId}</td>
						<td>${lib.issueDate}</td>
						<td>${lib.returnDate}</td>
						<td>${lib.returnedDate}</td>
						<td>${lib.amount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="common/footer.jspf"%>