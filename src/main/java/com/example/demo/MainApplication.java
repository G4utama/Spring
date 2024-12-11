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
@EnableBinding({ EmployeeConsumer.class, EmployeeProducer.class })
public class MainApplication {

    @Autowired
    MyRepository myRepository;

    @Autowired
    EmployeeProducer employeeProducer;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoCommandLineRunner() {
        return args -> {

            Employee employee = new Employee("John Doe", "john.doe@example.com");
            employeeProducer.sendEmployee(employee);

            System.out.println("Waiting...");
            Thread.sleep(3000);

            System.out.println("Employee count: " + myRepository.count());
            myRepository.findAll().forEach(System.out::println);

        };
    }

}
