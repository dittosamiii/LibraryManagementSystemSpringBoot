package com.springboot.webapp.Library.myLibrary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "library")
public class myLibrary {

	@Id
	@GeneratedValue
	private int bookId;
	private String username;
	private String bookName;
	private String authorName;
	private int price;
	private boolean done;

	public myLibrary() {

	}

	public myLibrary(String username, int bookId, String bookName, String authorName, int price, boolean done) {
		super();
		this.username = username;
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		this.done = done;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		;
	}

	@Override
	public String toString() {
		return "myLibrary [username=" + username + ", bookId=" + bookId + ", bookName=" + bookName + ", authorName="
				+ authorName + ", price=" + price + ", done=" + done + "]";
	}

}
