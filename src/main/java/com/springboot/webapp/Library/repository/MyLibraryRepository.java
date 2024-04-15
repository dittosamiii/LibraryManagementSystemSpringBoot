package com.springboot.webapp.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.webapp.Library.entity.MyLibrary;

@Repository
public interface MyLibraryRepository extends JpaRepository<MyLibrary, Integer> {
	public List<MyLibrary> findByUsername(String username);

}
