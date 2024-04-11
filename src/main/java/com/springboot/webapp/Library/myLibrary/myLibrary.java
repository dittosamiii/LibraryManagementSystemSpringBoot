package com.springboot.webapp.Library.myLibrary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "library")
public class myLibrary {

	@Id
	private int bookId;
	private String username;
	private String bookName;
	private String authorName;
	private int totalBooks;

	public myLibrary() {

	}

	public myLibrary(String username, int bookId, String bookName, String authorName, int totalBooks) {
		super();
		this.username = username;
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.totalBooks = totalBooks;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		;
	}

	public int getTotalBooks() {
		return totalBooks;
	}

	public void setTotalBooks(int totalBooks) {
		this.totalBooks = totalBooks;
	}

	@Override
	public String toString() {
		return "myLibrary [bookId=" + bookId + ", username=" + username + ", bookName=" + bookName + ", authorName="
				+ authorName + ", totalBooks=" + totalBooks + "]";
	}

}
