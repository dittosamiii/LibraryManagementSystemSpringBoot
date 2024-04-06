package com.springboot.webapp.Library.myLibrary.issueBook;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class issueBooks {

	public issueBooks(int bookId, int studentId, String studentName, String bookName, LocalDate issueDate,
			LocalDate returnDate) {
		super();
		this.bookId = bookId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.bookName = bookName;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

	@Id
	private int bookId;
	private int studentId;
	private String studentName;
	private String bookName;
	private LocalDate issueDate;
	private LocalDate returnDate;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "issueBooks [bookId=" + bookId + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", bookName=" + bookName + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
	}

}
