package com.springboot.webapp.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.webapp.Library.entity.IssueBooks;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBooks, Integer> {
	public List<IssueBooks> findByUsername(String username);
}
