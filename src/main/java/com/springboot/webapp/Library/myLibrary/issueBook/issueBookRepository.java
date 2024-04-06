package com.springboot.webapp.Library.myLibrary.issueBook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface issueBookRepository extends JpaRepository<issueBooks, Integer> {
	public List<issueBooks> findByUsername(String username);
}
