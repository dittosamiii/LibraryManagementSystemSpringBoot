<%@ include file="common/header.jspf"%>
<%@ include file="style/mainStyle.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">

	<h1>WELCOME ${name}</h1>
	<hr>
	<h2>Library Books:</h2>
	<div class="table-responsive">
		<table class="table table-scrollable">
			<thead>
				<tr>
					<th>BOOK ID</th>
					<th>BOOK NAME</th>
					<th>AUTHOR NAME</th>
					<th>AVAILABLE</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${library}" var="lib">
					<tr>
						<td>${lib.bookId}</td>
						<td>${lib.bookName}</td>
						<td>${lib.authorName}</td>
						<td>${lib.totalBooks}</td>
						<td><a
							href="issue-book?bookId=${lib.bookId}&bookName=${lib.bookName}"
							class="btn btn-success">ISSUE</a></td>
						<td><a href="update-book?bookId=${lib.bookId}"
							class="btn btn-light">UPDATE</a></td>
						<td><a href="delete-book?bookId=${lib.bookId}"
							class="btn btn-Danger">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<pre>${deleteError}</pre>
	</div>
	<a href="add-book" class="btn btn-success">Add Book</a>
</div>
<%@ include file="common/footer.jspf"%>
