package com.klu.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.course.entity.Course;
import com.klu.course.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course saved = service.addCourse(course);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Course course = service.getCourseById(id);
        if (course != null)
            return new ResponseEntity<>(course, HttpStatus.OK);
        else
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Course updated = service.updateCourse(id, course);
        if (updated != null)
            return new ResponseEntity<>(updated, HttpStatus.OK);
        else
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        boolean deleted = service.deleteCourse(id);
        if (deleted)
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }
}