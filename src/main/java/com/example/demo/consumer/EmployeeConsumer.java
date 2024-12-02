package com.example.demo.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
@EnableBinding(Sink.class)
public class EmployeeConsumer {

    @StreamListener
    public void receiveEmployee(Employee employee) {
        System.out.println("Received employee: " + employee);
    }
}