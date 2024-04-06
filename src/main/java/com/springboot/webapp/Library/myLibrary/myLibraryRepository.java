package com.springboot.webapp.Library.myLibrary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface myLibraryRepository extends JpaRepository<myLibrary, Integer> {
	public List<myLibrary> findByUsername(String username);
}
