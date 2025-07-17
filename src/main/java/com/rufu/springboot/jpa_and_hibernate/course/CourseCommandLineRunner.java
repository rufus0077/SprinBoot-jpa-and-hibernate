package com.rufu.springboot.jpa_and_hibernate.course;

import com.rufu.springboot.jpa_and_hibernate.course.datajpa.CourseDataJpaRepository;
import com.rufu.springboot.jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.rufu.springboot.jpa_and_hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "learn JPA", "codeWithRufu"));
        repository.save(new Course(2, "learn hibernate", "codeWithRufu"));
        repository.save(new Course(3, "learn security", "codeWithRufu"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));

        System.out.println(repository.findByAuthor("codeWithRufu"));
    }
}
