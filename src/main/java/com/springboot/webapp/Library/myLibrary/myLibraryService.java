//package com.springboot.webapp.Library.myLibrary;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//
//import org.springframework.stereotype.Service;
//
//import jakarta.validation.Valid;
//
//@Service
//public class myLibraryService {
//
//	private static List<myLibrary> books = new ArrayList<>();
//	static {
//		books.add(new myLibrary("admin",10021, "Harry Potter", "David Goggins", 1299, true));
//		books.add(new myLibrary("admin",10021, "Harry Potter", "David Goggins", 1299, true));
//		books.add(new myLibrary("admin",10021, "Harry Potter", "David Goggins", 1299, true));
//	}
//
//	public List<myLibrary> getBooks() {
//		return books;
//	}
//
//	public void addBook(String username, int bookId, String bookName, String authorName, int price, boolean available) {
//		myLibrary book = new myLibrary(username, bookId, bookName, authorName, price, available);
//		books.add(book);
//	}
//
//	public void deleteBookById(int id) {
//		Predicate<? super myLibrary> predicate = book -> book.getBookId() == id;
//		books.removeIf(predicate);
//	}
//
//	public myLibrary findById(int id) {
//		Predicate<? super myLibrary> predicate = book -> book.getBookId() == id;
//		myLibrary library = books.stream().filter(predicate).findFirst().get();
//		return library;
//	}
//
//	public void updateBooks(@Valid myLibrary book) {
//		deleteBookById(book.getBookId());
//		books.add(book);
//	}
//
//}
