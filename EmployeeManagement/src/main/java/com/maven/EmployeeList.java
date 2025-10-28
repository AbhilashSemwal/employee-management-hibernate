package com.maven;


import java.util.List;

import org.hibernate.*;

public class EmployeeList {
	
	public static void showEmployees() 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			List<Employee> employees = session.createQuery("from Employee",Employee.class).list();
			
			if(employees.isEmpty()) {
				System.out.println("No Employees Found");
			}else {
				System.out.println("-----> Employee List <-----");
				for(Employee emp:employees) {
					System.out.println("ID: " + emp.getEmpId()+" | Name: " + emp.getEmpName()+" | Sallary: " + emp.getEmpSalary());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
