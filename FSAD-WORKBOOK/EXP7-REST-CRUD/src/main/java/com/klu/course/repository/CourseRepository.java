package com.klu.course.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByTitleContaining(String title);
}