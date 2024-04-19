package com.springboot.webapp.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.webapp.Library.entity.Fine;

@Repository
public interface FineRepository extends JpaRepository<Fine, Integer> {
	public List<Fine> findByUsername(String username);

}
