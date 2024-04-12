package com.springboot.webapp.Library.myLibrary.issueBook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueBookRepository extends JpaRepository<IssueBooks, Integer> {
	public List<IssueBooks> findByUsername(String username);
}
