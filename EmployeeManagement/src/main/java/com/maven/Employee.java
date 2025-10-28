package com.maven;

import javax.persistence.*;

@Entity
@Table(name="EmployeeInfo")
public class Employee {
	@Id
	private int empId;
	private String empName;
	private double empSalary;
	
	// Getters
	public int getEmpId() {return empId;}
	public String getEmpName() {return empName;}
	public double getEmpSalary() {return empSalary;}

	//Setters
	public void setEmpId(int empId) {this.empId=empId;}
	public void setEmpName(String empName) {this.empName = empName;}
	public void setEmpSalary(double empSalary) {this.empSalary = empSalary;}
	
	// default constructor
	public Employee() {}
	
	// perameterised constructor
	public Employee(int empId,String empName,double empSalary) 
	{
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	
	@Override
	public String toString() {
		return "Employee  [empId = "+getEmpId()+", empName ="+getEmpName()+", empSalary ="+getEmpSalary()+"]";}
} 
