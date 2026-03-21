package com.klu.course.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.course.entity.Course;
import com.klu.course.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourseById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Course updateCourse(int id, Course course) {
        Course existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(course.getTitle());
            existing.setDuration(course.getDuration());
            existing.setFee(course.getFee());
            return repo.save(existing);
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContaining(title);
    }
}