package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.model.StudentDetails;

public class MainApp {
	public static void main(String args[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDetails student=(StudentDetails)context.getBean("StuDetails");
		
		student.display();
	}

}
