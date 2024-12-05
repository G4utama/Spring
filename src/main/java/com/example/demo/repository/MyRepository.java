package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

// Spring Data JPA creates CRUD implementation at runtime automatically.
public interface MyRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByName(String name);
 
}
