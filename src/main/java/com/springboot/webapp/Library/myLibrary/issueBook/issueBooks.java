package com.springboot.webapp.Library.myLibrary.issueBook;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
public class issueBooks {

	private int bookId;
	@Id
	@GeneratedValue
	private int sequence;
	@Min(value = 1, message = "Invalid Id")
	private int studentId;
	private String username;
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Invalid Name")
	private String studentName;
	private String bookName;
	private LocalDate issueDate;
	private LocalDate returnDate;

	public issueBooks() {

	}

	public issueBooks(int sequence, String username, int bookId, int studentId, String studentName, String bookName,
			LocalDate issueDate, LocalDate returnDate) {
		super();
		this.sequence = sequence;
		this.username = username;
		this.bookId = bookId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.bookName = bookName;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "issueBooks [bookId=" + bookId + ", sequence=" + sequence + ", studentId=" + studentId + ", username="
				+ username + ", studentName=" + studentName + ", bookName=" + bookName + ", issueDate=" + issueDate
				+ ", returnDate=" + returnDate + "]";
	}

}
