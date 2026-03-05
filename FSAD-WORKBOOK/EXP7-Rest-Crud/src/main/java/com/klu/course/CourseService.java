package com.klu.course;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course updateCourse(int id, Course updatedCourse) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return c;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        return courses.removeIf(c -> c.getCourseId() == id);
    }

    public Course getCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();

        for (Course c : courses) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }

        return result;
    }
}