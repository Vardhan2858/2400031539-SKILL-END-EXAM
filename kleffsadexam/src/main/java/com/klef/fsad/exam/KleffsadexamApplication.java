package com.klef.fsad.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class KleffsadexamApplication {

    @Autowired
    private DepartmentRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(KleffsadexamApplication.class, args);
    }

    @PostConstruct
    public void run() {

        // 🔹 INSERT
        Department dept = new Department();
        dept.setName("CSE");
        dept.setDescription("Computer Science Department");
        dept.setDate(new Date());
        dept.setStatus("Active");

        dept = repo.save(dept);
        System.out.println("Inserted ID: " + dept.getId());

        // 🔹 DELETE (based on ID)
        repo.deleteById(dept.getId());
        System.out.println("Deleted Successfully");
    }
}