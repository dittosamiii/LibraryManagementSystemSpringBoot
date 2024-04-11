package com.springboot.webapp.Library.myLibrary.fine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface fineRepository extends JpaRepository<fine, Integer> {
	public List<fine> findByUsername(String username);

}
