package com.klu;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		//load configuration and create session factory
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		
		//Open session
		Session session=factory.openSession();
		
		//begin transaction
		Transaction tx=session.beginTransaction();
		
		//create table/object
		Student s=new Student("Ravi");
		
		//save the data
		session.save(s);
		
		//commit
		tx.commit();
		
		//close the connection
		session.close();
		factory.close();
		
		System.out.println("Student data saved successfully");
		

	}

}
