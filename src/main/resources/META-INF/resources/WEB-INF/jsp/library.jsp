<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/main.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<h1>WELCOME ${name}</h1>
	<hr>
	<h2>Library Books:</h2>
	<table class="table">
		<thead>
			<tr>
				<th>BOOK ID</th>
				<th>BOOK NAME</th>
				<th>AUTHOR NAME</th>
				<th>PRICE</th>
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
					<td>${lib.price}</td>
					<td>${lib.done}</td>
					<td><a
						href="issue-book?bookId=${lib.bookId}&bookName=${lib.bookName}"
						class="btn btn-success">ISSUE</a></td>
					<td><a href="update-book?bookId=${lib.bookId}"
						class="btn btn-dark">UPDATE</a></td>
					<td><a href="delete-book?bookId=${lib.bookId}"
						class="btn btn-danger">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-book" class="btn btn-success">Add Book</a>
</div>
<%@ include file="common/footer.jspf"%>