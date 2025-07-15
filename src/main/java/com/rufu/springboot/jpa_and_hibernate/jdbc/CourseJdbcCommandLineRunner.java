package com.rufu.springboot.jpa_and_hibernate.jdbc;

import com.rufu.springboot.jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "learn JPA", "codeWithRufu"));
        repository.insert(new Course(2, "learn hibernate", "codeWithRufu"));
        repository.insert(new Course(3, "learn security", "codeWithRufu"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
