package com.springboot.webapp.Library.myLibrary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyLibraryRepository extends JpaRepository<MyLibrary, Integer> {
	public List<MyLibrary> findByUsername(String username);

}
