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

@SpringBootApplication
@EnableBinding({ EmployeeProducer.class, EmployeeConsumer.class })
public class MainApplication {

    @Autowired
    MyRepository myRepository;

    @Autowired
    EmployeeProducer employeeProducer;

    @Autowired
    EmployeeConsumer employeeConsumer;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoCommandLineRunner() {

        return args -> {

            // example

            System.out.println("Employee count: " + myRepository.count());
            System.out.println("Wait...");
            Thread.sleep(2000);

            Employee employee = new Employee("Mario Rossi", "mario.rossi@example.com");
            employeeProducer.sendEmployee(employee);
            employeeConsumer.receiveEmployee(employee);

            System.out.println("Employee count: " + myRepository.count());
            myRepository.findAll().forEach(System.out::println);

        };
        
    }

}
