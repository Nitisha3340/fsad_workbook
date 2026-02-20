package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CourseRegistration {
	@Value("40")
	private int rollNo;
	@Value("Minions")
	private String studentName;
	
	private String courseName;
	
	private int semester;
	
	public CourseRegistration(@Value("FSAD") String cname ) {
		
		courseName=cname;
		
	}
	 @Value("4")
	public void setSemester(int semester) {
		this.semester=semester;
	}
	
	public void display() {
		System.out.println("RollNo:"+rollNo);
		System.out.println("Name:"+studentName);
		System.out.println("Course Name:"+courseName);
		System.out.println("Semester:"+semester);
		
		
	}

}
