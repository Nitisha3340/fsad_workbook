package com.klu.autowire;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 101;
    private String name = "Spring Framework";
    private String dateOfCompletion = "10-03-2026";

    public String getDetails() {
        return "Certification ID: " + id +
               ", Name: " + name +
               ", Date: " + dateOfCompletion;
    }
}