package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import com.example.demo.consumer.EmployeeConsumer;
import com.example.demo.model.Employee;
import com.example.demo.producer.EmployeeProducer;
import com.example.demo.repository.MyRepository;


// @SpringBootApplication
// @EnableBinding(Processor.class)
// public class EmployeeApplication {
//     public static void main(String[] args) {
//         SpringApplication.run(EmployeeApplication.class, args);
//     }
// }

@SpringBootApplication
@EnableBinding({ EmployeeConsumer.class, EmployeeProducer.class })
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Autowired
    MyRepository myRepository;

    // @Autowired
    // EmployeeService employeeService;

    @Autowired
    EmployeeProducer employeeProducer;

    @Autowired
    EmployeeConsumer employeeConsumer;

    @Bean
    public CommandLineRunner demoCommandLineRunner() {
        return args -> {

            // Employee employee = myRepository.findById(1L).get();
            // System.out.println("Found employee: " + employee);

            Employee employee = new Employee("prova", "prova@prova.com");
            employeeConsumer.receiveEmployee(employee);

            employeeProducer.sendEmployee(employee);

            System.out.println("Employee count: " + myRepository.count());
            myRepository.findAll().forEach(System.out::println);

        };
    }

}

// how to connect kafka topic to a postgres db using spring cloud stream
// ok i wanna do the same thing but my message is an object from the class Employee(id,name,email)
