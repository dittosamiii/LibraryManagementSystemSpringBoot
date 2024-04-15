package com.springboot.webapp.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.webapp.Library.entity.Fine;

public interface FineRepository extends JpaRepository<Fine, Integer> {
	public List<Fine> findByUsername(String username);

}
