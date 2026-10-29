package com.student.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final StudentRepository repository;

    public DataSeeder(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new Student("Almas", "Kaisbayev", "DevOps-01"));
            System.out.println("Seeded test data for student: Kaisbayev Almas");
        }
    }
}
