<%@ include file="common/header.jspf"%>
<%@ include file="style/mainStyle.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<div class="container">

	<h1>WELCOME ${name}</h1>
	<hr>
	<h2>Issued Books:</h2>
	<div class="table-responsive">
		<table class="table table-scrollable">
			<thead>
				<tr>
					<th>BOOK ID</th>
					<th>STUDENT ID</th>
					<th>STUDENT NAME</th>
					<th>BOOK NAME</th>
					<th>ISSUE DATE</th>
					<th>RETURN DATE</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${issueBook}" var="lib">
					<tr>
						<td>${lib.bookId}</td>
						<td>${lib.studentId}</td>
						<td>${lib.studentName}</td>
						<td>${lib.bookName}</td>
						<td>${lib.issueDate}</td>
						<td>${lib.returnDate}</td>
						<td><a href="update-issue-book?sequence=${lib.sequence}"
							class="btn btn-light">UPDATE</a></td>
						<td><a href="return-issue-book?sequence=${lib.sequence}"
							class="btn btn-warning">RETURN</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="common/footer.jspf"%>