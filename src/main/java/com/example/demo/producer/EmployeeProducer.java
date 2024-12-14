package com.example.demo.producer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
@EnableBinding(Source.class)
public class EmployeeProducer {

    @SendTo("employee-topic")
    public Employee sendEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Employee is null");
            return null;
        } else {
            System.out.println("Sent employee: " + employee);
            return employee;
        }
    }

}
