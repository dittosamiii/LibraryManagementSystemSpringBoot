package com.springboot.webapp.Library.myLibrary.issueBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class issueBookService {

	private static List<issueBooks> issueBookList = new ArrayList<>();
	static {
		issueBookList
				.add(new issueBooks(112, 123212, "Samarth", "Harry Potter", LocalDate.now(), LocalDate.now().plusDays(10)));
		issueBookList
				.add(new issueBooks(121, 123322, "Samarth", "Harry Potter", LocalDate.now(), LocalDate.now().plusDays(10)));
		issueBookList
				.add(new issueBooks(3211, 123232, "Samarth", "Harry Potter", LocalDate.now(), LocalDate.now().plusDays(10)));
	}

	public List<issueBooks> getBooks() {
		return issueBookList;
	}

	public void issueBook(int bookId, int studentId, String studentName, String bookName, LocalDate issueDate,
			LocalDate returnDate) {
		issueBooks book = new issueBooks(bookId, studentId, studentName, bookName, issueDate, returnDate);
		issueBookList.add(book);
	}

	public void deleteBookById(int bookId) {
		Predicate<? super issueBooks> predicate = book -> book.getBookId() == bookId;
		issueBookList.removeIf(predicate);
	}

	public issueBooks findById(int id) {
		Predicate<? super issueBooks> predicate = book -> book.getBookId() == id;
		issueBooks book = issueBookList.stream().filter(predicate).findFirst().get();
		return book;
	}

}
