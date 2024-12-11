package com.example.demo.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeProducerTest {

    @Autowired
    private EmployeeProducer employeeProducer;

    @Test
    public void testSendEmployee() {
        // Create a test employee object
        Employee employee = new Employee("John Doe", "john.doe@example.com");

        // Call the sendEmployee method
        employeeProducer.sendEmployee(employee);

        // Verify that the employee object was sent correctly
        // You can add assertions here to verify the behavior
    }
}