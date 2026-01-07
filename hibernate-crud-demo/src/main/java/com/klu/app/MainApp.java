package com.klu.app;
import com.klu.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.klu.util.HibernateUtil;
import java.util.Scanner;

public class MainApp {
	static SessionFactory factory=HibernateUtil.getSessionFactory();
	public static void main(String args[]) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("....Main Menu....");	
			System.out.println("1.Insert Employee");
			System.out.println("2.Display Employee");
			System.out.println("3.Update Employee");
			System.out.println("4.Delete Employee");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice) {
			case 1:insertEmployee(sc);
			break;
			case 2:displayEmployee(sc);
			break;
			case 3:updateEmployee(sc);
			break;
			case 4:deleteEmployee(sc);
			break;
			case 5:System.out.println("Thank u!");
			break;
			default:System.out.println("Wrong choice");
			break;
			
			}	
			
		}while(choice!=5);
		factory.close();
		session.close();
	}
	 private static void insertEmployee(Scanner sc){
		 Session session=factory.openSession();
		 Transaction tx=session.beginTransaction();
		 System.out.println("Enter Employee name:");
		 String ename=sc.next();
		 System.out.println("Enter Employee salary:");
		 double salary=sc.nextDouble();
		 System.out.println("Enter Dept name:");
		 String deptName=sc.next();
		 
		 Department dept=new Department();
		 dept.setDeptName(deptName);
		 
		 Employee emp=new Employee();
		 emp.setEmpName(ename);
		 emp.setEmpSalary(salary);
		 emp.setDepartment(dept);
		 
		 session.persist(dept);
		 session.persist(emp);
		 
		 tx.commit();
		 session.close();
		 System.out.println("Employee inserted successfully");
	 } 
	     static void displayEmployee(Scanner sc) {
			 Session session=factory.openSession();
			 
			 System.out.print("Enter Employee Id: ");
			 int id=sc.nextInt();
			 Employee emp=session.get(Employee.class,id);
			 if(emp !=null) {
				 System.out.println("Name: "+emp.getEmpName());
				 
				 System.out.println("Salary: "+emp.getEmpSalary());
				 
				 System.out.println("Dept :"+emp.getDepartment().getDeptName());
			 }else {
				 System.out.println("Employee not there!");
			 }
			 session.close();
			 
		 }
		 static void updateEmployee(Scanner sc) {
			 Session session=factory.openSession();
			 Transaction tx=session.beginTransaction();
			 
			 System.out.println("Enter Employee id:");
			 int id=sc.nextInt();
			 
			 Employee emp=session.get(Employee.class, id);
			 
			 if(emp !=null) {
				 System.out.println("Enter new Salary:");
				 emp.setEmpSalary(sc.nextDouble());
				 tx.commit();
				 System.out.println("Salary updated!");
				 
			 }else {
				 System.out.println("Employee not found!");
				 tx.rollback();
			 }
			 session.close();
			 
		 }
		 static void deleteEmployee(Scanner sc) {
			 Session session=factory.openSession();
			 Transaction tx=session.beginTransaction();
			 
			 System.out.println("Enter Employee id:");
			 int id=sc.nextInt();
			 
			 Employee emp=session.get(Employee.class, id);
			 
			 if(emp !=null) {
				session.remove(emp);
				 tx.commit();
				 System.out.println("Employee deleted");
				 
			 }else {
				 System.out.println("Employee not found!");
				 tx.rollback();
			 }
			 session.close();
			 
		 }	 
		
	}


