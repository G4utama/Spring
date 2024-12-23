package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.MyRepository;

@Service
public class EmployeeService {

    @Autowired
    private MyRepository myRepository;

    @Query("SELECT e FROM employee e")
    public List<Employee> findAll() {
        return myRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return myRepository.findById(id);
    }

    // insert a employee in the repo
    @Query("INSERT INTO employee (name, email) VALUES (:name, :email)")
    public Employee save(Employee employee) {
        return myRepository.save(employee);
    }

    // take a Employee from the repo
    @Query("SELECT e FROM employee e WHERE e.id = :id")
    public Employee update(Employee employee) {
        return myRepository.save(employee);
    }

    public void deleteById(Long id) {
        myRepository.deleteById(id);
    }

}
