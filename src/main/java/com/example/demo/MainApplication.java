package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.MyRepository;

// @SpringBootApplication
// @EnableBinding(Processor.class)
// public class EmployeeApplication {
//     public static void main(String[] args) {
//         SpringApplication.run(EmployeeApplication.class, args);
//     }
// }

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Autowired
    MyRepository myRepository;

    @Bean
    public CommandLineRunner demoCommandLineRunner() {
        return args -> {

            System.out.println("Employee count: " + myRepository.count());
            myRepository.findAll().forEach(System.out::println);

        };
    }

}
