package com.example.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

// import org.springframework.cloud.stream.annotation.SendTo;

@Service
@EnableBinding(Source.class)
public class EmployeeProducer {

    @Autowired
    private Source source;

    // @SendTo("demo.input")

    public void sendEmployee(Employee employee) {
        // source.output().send(MessageBuilder.withPayload(employee).build());
        System.out.println("Sent employee: " + employee);
    }
}
