package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public interface MyRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByName(String name);
 
}
