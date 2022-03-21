package com.theatmo.model;

import java.sql.Date;

/**
 * Gives information about employee details.
 */
public class Employee {
   
    /**
	 * Represents employee name, salary, contact number,and dateOfBirth.
	 */
	private int  employeeId ;
	private String employeeName;
	private String salary;
	private String contactNumber;
	private Date dateOfJoining;
	
	public Employee() {
		super();
	}

    /**
	 * This Constructor creates an employee data
	 * @param employeeId      
	 * @param employeeName    
	 * @param salary          
	 * @param contactNumber         
	 * @param dateOfBirth            
	 */
	public Employee (int  employeeId, String employeeName, String salary, String contactNumber, Date dateOfJoining) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.contactNumber = contactNumber;
		this.dateOfJoining = dateOfJoining;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getSalary() {
		return salary;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setDateOfJoining(Date dateOfBirth) {
		this.dateOfJoining = dateOfBirth;
	}
	
	public String toString() {
		return new StringBuffer().append("\n").append("EmployeeId:").append(employeeId).append("\n").append("Name:").append(employeeName).append("\n").append("Salary:").append(salary).
				append("\n").append("Contact Number:").append(contactNumber).append("\n").append("DateOfJoining:").append(dateOfJoining).append("\n").append("\n").toString();
	}
}
