
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.MyRepository;

@Service
public class EmployeeService {

    @Autowired
    private MyRepository myRepository;

    public List<Employee> findAll() {
        return myRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return myRepository.findById(id);
    }

    public Employee save(Employee employee) {
        return myRepository.save(employee);
    }

    public void deleteById(Long id) {
        myRepository.deleteById(id);
    }

}
