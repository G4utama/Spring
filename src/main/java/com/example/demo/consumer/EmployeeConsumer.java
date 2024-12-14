package com.example.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.MyRepository;

import jakarta.transaction.Transactional;

@Service
@EnableBinding(Sink.class)
public class EmployeeConsumer {

    @Autowired
    private MyRepository myRepository;

    @StreamListener("employee-topic")
    @Transactional
    public void receiveEmployee(Employee employee) {
        try {
            if (employee == null) {
                System.out.println("Employee is null");
                return;
            }
            System.out.println("Received employee: " + employee);
            myRepository.save(employee);
            System.out.println("Saved employee: " + employee);
        } catch (Exception e) {
            System.out.println("Error processing employee: " + e.getMessage());
        }
    }
    
}
