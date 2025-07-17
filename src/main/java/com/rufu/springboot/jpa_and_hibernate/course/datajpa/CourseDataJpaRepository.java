package com.rufu.springboot.jpa_and_hibernate.course.datajpa;

import com.rufu.springboot.jpa_and_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDataJpaRepository extends JpaRepository<Course, Integer> {
    List<Course> findByAuthor(String author);
}
