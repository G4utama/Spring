package com.example.demo.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;
import com.example.demo.repository.MyRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeConsumerTest {

    @Autowired
    private Sink sink;

    @Autowired
    private MyRepository myRepository;

    @Test
    public void testReceiveEmployee() {
        // Create a test employee object
        Employee employee = new Employee("John Doe", "john.doe@example.com");

        // Create a test message
        Message<Employee> message = MessageBuilder.withPayload(employee).build();

        // Send the message to the input channel
        sink.input().send(message);

        // Verify that the employee object was processed correctly
        // You can add assertions here to verify the behavior
        assert myRepository.count() == 1;
        assert myRepository.findAll().get(0).getName().equals(employee.getName());
        assert myRepository.findAll().get(0).getEmail().equals(employee.getEmail());
    }
}