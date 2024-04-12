package com.springboot.webapp.Library.myLibrary.fine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, Integer> {
	public List<Fine> findByUsername(String username);

}
