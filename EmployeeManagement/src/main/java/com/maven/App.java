package com.maven;
import java.util.Scanner;
public class App {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		
		while(true) 
		{
			UserInterface.userInterface();
			System.out.print("User Input: ");
			int userInput = sc.nextInt();
			
			switch (userInput) {
			case 1:
				System.out.println("---> Enter Employee Details <---");
				EmployeeInsert.insertEmployee(sc);
				break;
			case 2:
				System.out.println("---> Change Employee Details <---");
				EmployeeUpdate.updateEmployee(sc);
				break;
			case 3:
				System.out.println("----> Showing All Employees Details <----");
				EmployeeList.showEmployees();
				break;
			case 4:
				System.out.println("----> Delete Employee Details  <----");
				EmployeeDelete.deleteEmployee(sc);
				break;
			case 5:
				System.out.println("Exiting...");
				sc.close();
				HibernateUtil.getSessionFactory().close();
				return;

			default:
				System.out.println("Invalid User Input..");
				break;
			}
			
		}
		
	}

}
