package com.example.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
@EnableBinding(Source.class)
public class EmployeeProducer {

    @Autowired
    private Source source;

    public void sendEmployee(Employee employee) {
        source.output().send(MessageBuilder.withPayload(employee).build());
    }
}
