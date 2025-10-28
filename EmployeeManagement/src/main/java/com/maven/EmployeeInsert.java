package com.maven;

import java.util.Scanner;
import org.hibernate.*;

public class EmployeeInsert {

    public static void insertEmployee(Scanner sc) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = null;

        try {
            System.out.print("Enter Emp id: ");
            int empId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Emp Name: ");
            String empName = sc.nextLine();

            System.out.print("Enter Emp Salary: ");
            double empSalary = sc.nextDouble();

            txn = session.beginTransaction();
            session.save(new Employee(empId, empName, empSalary));
            txn.commit();
            System.out.println("Employee inserted successfully.");

        } catch (Exception e) {
            if (txn != null) txn.rollback();
            e.printStackTrace();
        } finally {
            session.close();
         
        }
    }
}
