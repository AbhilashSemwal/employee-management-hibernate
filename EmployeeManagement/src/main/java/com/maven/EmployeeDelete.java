package com.maven;

import java.util.Scanner;
import org.hibernate.*;

public class EmployeeDelete {
	
	public static void deleteEmployee(Scanner sc) 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		try {
			System.out.print("Enter Employee id: ");
			int empId =  sc.nextInt();
			sc.nextLine();
			
			txn = session.beginTransaction();
			
			Employee emp = session.get(Employee.class, empId); 
			if(emp == null) {
				System.out.println("Employee Not Found");
				return;
			}else {
				session.remove(emp);
				System.out.println("Employee Info Deleted Successfully.");
			}
			
			//session update
			txn.commit();
			
			}catch(Exception e) {
				if(txn != null) txn.rollback();
				e.printStackTrace();
			}finally {
				session.close();
			}
	}
}
