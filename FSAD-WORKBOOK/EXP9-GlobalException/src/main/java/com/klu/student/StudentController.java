package com.klu.student;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Student ID must be a number");
        }

        if (studentId != 1) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        }

        return new Student(1, "Nitisha", "Computer Science");
    }
}