package com.maven;

import java.util.Scanner;
import org.hibernate.*;

public class EmployeeUpdate {
	
	public static void updateEmployee(Scanner sc) 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		
	try {
		System.out.print("Enter Employee id: ");
		int empId =  sc.nextInt();
		sc.nextLine();
		
		Employee emp = session.get(Employee.class, empId);
		if(emp == null) {
			System.out.println("Employee Not Found");
			return;
		}
		
		// taking input from user
		System.out.println("1. Change Name: ");
		System.out.println("2. Change Salary: ");
		System.out.print("Input: ");
		int input = sc.nextInt();
		sc.nextLine();
		
		if (input != 1 && input != 2) {
            System.out.println("Invalid input.");
            return;
        }

		txn = session.beginTransaction();
		
		 if (input == 1) {
             System.out.print("Enter new Name: ");
             String newName = sc.nextLine();
             emp.setEmpName(newName);
             System.out.println("Name updated successfully.");
         } else {
             System.out.print("Enter new Salary: ");
             double newSalary = sc.nextDouble();
             emp.setEmpSalary(newSalary);
             System.out.println("Salary updated successfully.");
         }
		
		//session update
		session.update(emp);
		txn.commit();
		
		}catch(Exception e) {
			if(txn != null) txn.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			
		}
	}
}
