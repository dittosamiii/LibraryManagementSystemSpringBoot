package com.springboot.webapp.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.webapp.Library.entity.IssueBooks;

public interface IssueBookRepository extends JpaRepository<IssueBooks, Integer> {
	public List<IssueBooks> findByUsername(String username);
}
