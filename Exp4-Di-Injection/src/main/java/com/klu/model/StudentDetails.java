package com.klu.model;

public class StudentDetails {
	private int StuId;
	private String Name;
	private String Course;
	private int Year;
	
	public StudentDetails(int StuId,String Name){
		this.StuId=StuId;
		this.Name=Name;	
	}
	public void setCourse(String Course) {
		this.Course=Course;
	}
	public void setYear(int Year) {
		this.Year=Year;
	}
	public void display() {
		System.out.println("Student Id:"+StuId);
		System.out.println("Name:"+Name);
		System.out.println("Course:"+Course);
		System.out.println("Year:"+Year);
	}

}
