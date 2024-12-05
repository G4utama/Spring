package com.example.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.MyRepository;

@Service
@EnableBinding(Sink.class)
public class EmployeeConsumer {

    @Autowired
    private MyRepository myRepository;

    @StreamListener("demo.output")
    public void receiveEmployee(Employee employee) {
        myRepository.save(employee);
        System.out.println("Received employee: " + employee);
    }
}
