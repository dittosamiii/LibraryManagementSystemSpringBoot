<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/main.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>WELCOME ${name}</h1>
	<hr>

	<h2>Issued Books:</h2>
	<table class="table">
		<thead>
			<tr>
				<th>BOOKID</th>
				<th>STUDENTID</th>
				<th>STUDENTNAME</th>
				<th>BOOK NAME</th>
				<th>ISSUEDATE</th>
				<th>RETURNDATE</th>
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
					<td><a href="delete-issue-book?bookId=${lib.bookId}"
						class="btn btn-warning">DELETE</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a href="issue-book" class="btn btn-success">Issue Book</a>
</div>
<%@ include file="common/footer.jspf"%>